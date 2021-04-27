package com.redgrapefruit.improvedfood.block.entity;

import com.redgrapefruit.improvedfood.registry.BlockRegistry;
import com.redgrapefruit.improvedfood.screen.handler.SalterScreenHandler;
import com.redgrapefruit.redcore.container.ExtendedContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import org.jetbrains.annotations.Nullable;

/**
 * The salter block entity implemented using RedCore.Container library
 */
public class SalterBlockEntity extends ExtendedContainerBlockEntity {
    // Synced countdown int
    private int countdown = 0;

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
        return new SalterScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    protected PropertyDelegate constructDelegate() {
        return new PropertyDelegate() {
            @Override
            public int get(int index) {
                return countdown;
            }

            @Override
            public void set(int index, int value) {
                countdown = value;
            }

            @Override
            public int size() {
                return 1;
            }
        };
    }

    @Override
    protected void deserialize(CompoundTag tag) {
        countdown = tag.getInt("Countdown");
    }

    @Override
    protected void serialize(CompoundTag tag) {
        tag.putInt("Countdown", countdown);
    }

    @Override
    public void tick() {

    }
}
