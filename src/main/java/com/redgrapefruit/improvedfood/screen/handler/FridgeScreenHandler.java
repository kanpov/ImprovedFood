package com.redgrapefruit.improvedfood.screen.handler;

import com.redgrapefruit.improvedfood.registry.GuiRegistry;
import com.redgrapefruit.redcore.container.ContainerScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;

/**
 * A fridge screen handler implemented using RedCore.Container library
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
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                addGridSlot(inventory, y + x, x, y);
            }
        }
        // Player inventory and hotbar
        addPlayerInventorySlots(playerInventory);
        addPlayerHotbarSlots(playerInventory);
    }

    @Override
    protected void onListenerInit() {

    }
}
