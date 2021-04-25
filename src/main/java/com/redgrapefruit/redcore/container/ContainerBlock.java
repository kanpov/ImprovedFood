package com.redgrapefruit.redcore.container;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * A container block synced with a container block entity.<br>
 * Opens a screen & a screen handler when right-clicked.<br>
 * Also acts as a directional block.<br><br>
 * A part of RedCore.Container library bundled with this mod.
 */
public abstract class ContainerBlock extends BlockWithEntity {
    protected DirectionProperty FACING; // Facing property

    /**
     * Checks if given block entity is instanceof current block entity
     * @param blockEntity Given block entity
     * @return Yes/No
     */
    protected abstract boolean checkBlockEntity(BlockEntity blockEntity);

    /**
     * Casts current block entity to an inventory
     * @param blockEntity Current block entity
     * @return Casted to inventory
     */
    protected abstract Inventory castToInventory(BlockEntity blockEntity);

    /**
     * Child constructor initializing the container block
     * @param settings Block settings
     */
    protected ContainerBlock(Settings settings) {
        super(settings);
        // Defaults facing property
        setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        FACING = Properties.HORIZONTAL_FACING;
        builder.add(FACING);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // BlockWithEntity resets render type to INVISIBLE, so we deny it
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        // This operation is server-side
        if (!world.isClient) {
            // Create a screen handler factory and open the screen on the player's HUD
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        // Proceed if the block has changed
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            // If the block entity is current block entity, drop everything and update comparators
            if (checkBlockEntity(blockEntity)) {
                ItemScatterer.spawn(world, pos, castToInventory(blockEntity));
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }
}
