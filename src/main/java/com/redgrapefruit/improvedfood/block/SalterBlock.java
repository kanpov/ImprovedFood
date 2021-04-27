package com.redgrapefruit.improvedfood.block;

import com.redgrapefruit.improvedfood.block.entity.SalterBlockEntity;
import com.redgrapefruit.redcore.container.ContainerBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

/**
 * A salter block implemented using RedCore.Container library
 */
public class SalterBlock extends ContainerBlock {
    public SalterBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean checkBlockEntity(BlockEntity blockEntity) {
        return blockEntity instanceof SalterBlockEntity;
    }

    @Override
    protected Inventory castToInventory(BlockEntity blockEntity) {
        return (SalterBlockEntity) blockEntity;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new SalterBlockEntity();
    }
}
