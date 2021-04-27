package com.redgrapefruit.improvedfood.screen.handler;

import com.redgrapefruit.improvedfood.registry.GuiRegistry;
import com.redgrapefruit.redcore.container.ExtendedContainerScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;

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
}
