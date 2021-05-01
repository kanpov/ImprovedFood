package com.redgrapefruit.improvedfood.screen.handler;

import com.redgrapefruit.improvedfood.item.FoodItem;
import com.redgrapefruit.improvedfood.item.SaltItem;
import com.redgrapefruit.improvedfood.item.SaltedFoodItem;
import com.redgrapefruit.improvedfood.registry.GuiRegistry;
import com.redgrapefruit.improvedfood.util.ItemMixinAccess;
import com.redgrapefruit.redcore.container.ExtendedContainerScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.util.collection.DefaultedList;

/**
 * A salter screen handler implemented using RedCore.Container library
 */
public class SalterScreenHandler extends ExtendedContainerScreenHandler {
    public SalterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(3), new ArrayPropertyDelegate(1));
    }

    public SalterScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(syncId, playerInventory, inventory, propertyDelegate, 3, GuiRegistry.SALTER_SCREEN_HANDLER);
    }

    @Override
    protected void onSlotInit(Inventory inventory, PlayerInventory playerInventory) {
        // Custom inventory
        addGridSlot(inventory, 0, 0, 1);
        addGridSlot(inventory, 1, 2, 1);
        addGridSlot(inventory, 2, 4, 1);
        // Player inventory and hotbar
        addPlayerInventorySlots(playerInventory);
        addPlayerHotbarSlots(playerInventory);
    }

    @Override
    protected void onListenerInit() {

    }

    private static class Listener implements ScreenHandlerListener {
        // Property delegate inherited from parent class
        private final PropertyDelegate propertyDelegate;
        // Tracked inventory
        private DefaultedList<ItemStack> stacks;

        public Listener(PropertyDelegate propertyDelegate) {
            this.propertyDelegate = propertyDelegate;
        }

        @Override
        public void onHandlerRegistered(ScreenHandler handler, DefaultedList<ItemStack> stacks) {
            this.stacks = stacks;
        }

        @Override
        public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
            // Update item in the tracked inventory
            stacks.set(slotId, stack);

            // Extract stacks from tracked inventory
            ItemStack inputStack = stacks.get(0);
            ItemStack saltStack = stacks.get(1);

            // Check input and salt stacks
            if (isFoodStackInvalid(inputStack) || !(saltStack.getItem() instanceof SaltItem)) return;

            // Empty the output stack
            resetOutputContainment(Items.AIR, 0);

            // Calculate max amount of salted food which can be produced using the current stock
            int amount = Math.min(inputStack.getCount(), saltStack.getCount());
            // Check the amount
            if (amount <= 0) return;

            // Produce
            SaltedFoodItem saltedVariant;

            if (inputStack.getItem() instanceof FoodItem) {
                saltedVariant = ((FoodItem) inputStack.getItem()).getSaltedVariant();
            } else {
                saltedVariant = ((ItemMixinAccess) inputStack.getItem()).getSaltedVariant();
            }

            resetOutputContainment(saltedVariant, amount);

            // Decrement
            inputStack.decrement(amount);
            saltStack.decrement(amount);
        }

        @Override
        public void onPropertyUpdate(ScreenHandler handler, int property, int value) {

        }

        /**
         * Checks the food stack on both implementations for validity
         *
         * @param stack Food stack
         * @return Is invalid
         */
        private boolean isFoodStackInvalid(ItemStack stack) {
            return !(stack.getItem() instanceof FoodItem) && (!((ItemMixinAccess) stack.getItem()).isActivated());
        }

        /**
         * Resets the containment of the output slot to a new item
         *
         * @param newContainment New containment item
         * @param count          The amount of this new containment item
         * @return Created stack
         */
        private ItemStack resetOutputContainment(Item newContainment, int count) {
            // Create stack and increment it to given count
            ItemStack stack = new ItemStack(newContainment);
            stack.increment(count - 1);
            // Update it in the tracked inventory
            stacks.set(2, stack);

            return stack;
        }
    }
}
