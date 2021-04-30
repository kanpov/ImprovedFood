package com.redgrapefruit.redcore.container;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.Tickable;

/**
 * A container block entity with property delegate support and out-of-the-box tick() event attached.<br><br>
 * A part of RedCore.Container library bundled with this mod.
 */
public abstract class ExtendedContainerBlockEntity extends ContainerBlockEntity implements Tickable {
    protected PropertyDelegate propertyDelegate;

    protected ExtendedContainerBlockEntity(BlockEntityType<?> type) {
        super(type);
        // Construct property delegate
        propertyDelegate = constructDelegate();
    }

    /**
     * Constructs the property delegate
     *
     * @return Created property delegate
     */
    protected abstract PropertyDelegate constructDelegate();

    /**
     * Deserialize property delegate vars from tag
     *
     * @param tag Input tag
     */
    protected abstract void deserialize(CompoundTag tag);

    /**
     * Serializes property delegate vars into tag
     *
     * @param tag Output tag
     */
    protected abstract void serialize(CompoundTag tag);

    // S&D overrides

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        deserialize(tag); // Fire event
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        serialize(tag); // Fire event
        return tag;
    }
}
