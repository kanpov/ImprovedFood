package com.redgrapefruit.improvedfood.common.block.entity;

import com.redgrapefruit.improvedfood.common.registry.BlockRegistry;
import com.redgrapefruit.improvedfood.common.screen.handler.FridgeScreenHandler;
import com.redgrapefruit.improvedfood.api.ContainerBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import org.jetbrains.annotations.Nullable;

/**
 * A fridge {@link BlockEntity} implemented using RedCore.Container library
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
