package com.redgrapefruit.improvedfood.screen.handler;

import com.redgrapefruit.improvedfood.item.FoodItem;
import com.redgrapefruit.improvedfood.registry.GuiRegistry;
import com.redgrapefruit.improvedfood.util.ItemMixinAccess;
import com.redgrapefruit.redcore.container.ContainerScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.util.collection.DefaultedList;

/**
 * A fridge {@link ScreenHandler} implemented using RedCore.Container library
 */
public class FridgeScreenHandler extends ContainerScreenHandler {
    public FridgeScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9));
    }

    public FridgeScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(syncId, playerInventory, inventory, 9, GuiRegistry.FRIDGE_SCREEN_HANDLER);
    }

    @Override
    protected void onSlotInit(Inventory inventory, PlayerInventory playerInventory) {
        // Custom 3x3 inventory
        int index = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                addGridSlot(inventory, index, x, y);
                index++;
            }
        }
        // Player inventory and hotbar
        addPlayerInventorySlots(playerInventory);
        addPlayerHotbarSlots(playerInventory);
    }

    @Override
    protected void onListenerInit() {
        addListener(new Listener());
    }

    private static class Listener implements ScreenHandlerListener {
        private DefaultedList<ItemStack> stacks;

        @Override
        public void onHandlerRegistered(ScreenHandler handler, DefaultedList<ItemStack> stacks) {
            this.stacks = stacks;
        }

        @Override
        public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
            // The listener doesn't track player's slots
            if (slotId > 9) return;

            // Track current and previous item at this slot and proceed if they are different
            Item currentItem = stack.getItem();
            Item previousItem = stacks.get(slotId).getItem();

            if (currentItem == previousItem) return;

            // If previous item is a food item, toggle its isInFridge off
            // If current item is a food item, toggle its isInFridge on
            // When processing the mixin implementation, make sure the item is activated
            if (currentItem instanceof FoodItem) {
                FoodItem item = (FoodItem) currentItem;
                item.getProfile().toggleInFridge(true);
            }
            if (previousItem instanceof FoodItem) {
                FoodItem item = (FoodItem) previousItem;
                item.getProfile().toggleInFridge(false);
            }
            if (currentItem instanceof ItemMixinAccess) {
                ItemMixinAccess access = (ItemMixinAccess) currentItem;

                if (access.isActivated()) {
                    access.getFoodProfile().toggleInFridge(true);
                }
            }
            if (previousItem instanceof ItemMixinAccess) {
                ItemMixinAccess access = (ItemMixinAccess) previousItem;

                if (access.isActivated()) {
                    access.getFoodProfile().toggleInFridge(false);
                }
            }

            // Update the stack
            stacks.set(slotId, stack);
        }

        @Override
        public void onPropertyUpdate(ScreenHandler handler, int property, int value) {

        }
    }
}
