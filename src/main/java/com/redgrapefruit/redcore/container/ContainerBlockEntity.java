package com.redgrapefruit.redcore.container;

import com.redgrapefruit.redcore.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

/**
 * A container block entity storing, serializing & deserializing an embedded inventory.<br>
 * Also manages the creation of current screen handler.<br><br>
 * A part of RedCore.Container library bundled with this mod.
 */
public abstract class ContainerBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {
    // Embedded inventory represented through a DefaultedList
    protected final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(getContainerSize(), ItemStack.EMPTY);

    /**
     * Returns the size of the container
     * @return Container size
     */
    protected abstract int getContainerSize();

    /**
     * Child constructor creating a container block entity
     * @param type Registered block entity type
     */
    protected ContainerBlockEntity(BlockEntityType<?> type) {
        super(type);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        // Deserialization method
        super.fromTag(state, tag);
        Inventories.fromTag(tag, inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        // Serialization method
        super.toTag(tag);
        Inventories.toTag(tag, inventory);
        return tag;
    }
}
