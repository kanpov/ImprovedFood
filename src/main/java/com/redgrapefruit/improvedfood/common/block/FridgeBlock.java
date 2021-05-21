package com.redgrapefruit.improvedfood.common.block;

import com.redgrapefruit.improvedfood.common.block.entity.FridgeBlockEntity;
import com.redgrapefruit.redcore.container.ContainerBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

/**
 * A fridge block implemented using RedCore.Container library
 */
public class FridgeBlock extends ContainerBlock {
    public FridgeBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean checkBlockEntity(BlockEntity blockEntity) {
        return blockEntity instanceof FridgeBlockEntity;
    }

    @Override
    protected Inventory castToInventory(BlockEntity blockEntity) {
        return (FridgeBlockEntity) blockEntity;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new FridgeBlockEntity();
    }
}
