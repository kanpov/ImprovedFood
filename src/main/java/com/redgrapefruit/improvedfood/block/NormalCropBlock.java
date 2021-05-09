package com.redgrapefruit.improvedfood.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

/**
 * A normal crop block with regular voxel shapes and logic
 */
public class NormalCropBlock extends CropBlock {
    // A list of voxel shapes for each crop age value
    protected static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)
    };

    private final Item seeds;

    public NormalCropBlock(Item seeds) {
        super(FabricBlockSettings
                .of(Material.PLANT)
                .breakByHand(false)
                .nonOpaque());

        this.seeds = seeds;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // Returns the corresponding voxel shape for the current age value
        return AGE_TO_SHAPE[state.get(this.getAgeProperty())];
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return seeds;
    }
}
