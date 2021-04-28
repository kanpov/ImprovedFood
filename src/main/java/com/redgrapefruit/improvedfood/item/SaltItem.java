package com.redgrapefruit.improvedfood.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

/**
 * Salt is used as a material in the salter.<br>
 * Can be obtained by mining salt ore.
 */
public class SaltItem extends Item {
    public SaltItem() {
        super(new Item.Settings().group(ItemGroup.MISC));
    }
}
