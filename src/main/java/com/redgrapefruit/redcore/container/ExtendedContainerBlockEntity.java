package com.redgrapefruit.redcore.container;

import com.redgrapefruit.redcore.container.ContainerBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.Tickable;

/**
 * A container block entity with property delegate support
 */
public abstract class ExtendedContainerBlockEntity extends ContainerBlockEntity implements Tickable {
    protected PropertyDelegate propertyDelegate;

    protected ExtendedContainerBlockEntity(BlockEntityType<?> type) {
        super(type);
    }

    /**
     * Constructs the property delegate
     * @return Created property delegate
     */
    protected abstract PropertyDelegate constructDelegate();
}
