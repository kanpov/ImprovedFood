package com.redgrapefruit.improvedfood.block.entity;

import com.redgrapefruit.improvedfood.registry.BlockRegistry;
import com.redgrapefruit.improvedfood.screen.handler.FridgeScreenHandler;
import com.redgrapefruit.redcore.container.ContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import org.jetbrains.annotations.Nullable;

/**
 * A fridge block entity implemented using RedCore.Container library
 */
public class FridgeBlockEntity extends ContainerBlockEntity {
    public FridgeBlockEntity() {
        super(BlockRegistry.FRIDGE_BLOCK_ENTITY);
    }

    @Override
    protected int getContainerSize() {
        return 9;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new FridgeScreenHandler(syncId, playerInventory, this);
    }
}
