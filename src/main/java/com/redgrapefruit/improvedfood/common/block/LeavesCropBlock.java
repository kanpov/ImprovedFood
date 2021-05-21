package com.redgrapefruit.improvedfood.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

/**
 * A leaves crop block with 0 to 3 age scale
 */
public class LeavesCropBlock extends NormalCropBlock {
    // Leaves have a custom age property on a scale of 0 to 3
    public static final IntProperty AGE = Properties.AGE_3;

    public LeavesCropBlock(Item seeds, Item drop) {
        super(seeds);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // Leaves crops are always a full cube
        return VoxelShapes.fullCube();
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        // Leaves crops can be planted anywhere except farmland
        return floor != Blocks.FARMLAND.getDefaultState();
    }

    @Override
    public int getMaxAge() {
        // Leaves crops use 0 to 3 age scale
        return 3;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
