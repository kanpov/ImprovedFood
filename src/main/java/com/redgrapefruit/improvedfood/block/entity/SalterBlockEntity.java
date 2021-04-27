package com.redgrapefruit.improvedfood.block.entity;

import com.redgrapefruit.improvedfood.registry.BlockRegistry;
import com.redgrapefruit.improvedfood.screen.handler.SalterScreenHandler;
import com.redgrapefruit.redcore.container.ContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import org.jetbrains.annotations.Nullable;

/**
 * The salter block entity implemented using RedCore.Container library
 */
public class SalterBlockEntity extends ContainerBlockEntity {
    public SalterBlockEntity() {
        super(BlockRegistry.SALTER_BLOCK_ENTITY);
    }

    @Override
    protected int getContainerSize() {
        return 3;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new SalterScreenHandler(syncId, playerInventory, this);
    }
}
