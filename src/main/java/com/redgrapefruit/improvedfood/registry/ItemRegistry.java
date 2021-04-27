package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import com.redgrapefruit.improvedfood.item.RottenFoodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers mod items into Minecraft.
 */
public class ItemRegistry {
    // Rotten variants
    public static final RottenFoodItem PORKCHOP_ROTTEN = new RottenFoodItem(ConfigRegistry.PORKCHOP);

    // Overdue variants

    // Miscellaneous
    public static final Item SALT = new Item(new Item.Settings().group(ItemGroup.MISC));

    /**
     * Runs the registry code
     */
    public static void run() {
        register("salt", SALT);
    }

    /**
     * Registers an item to Minecraft.
     *
     * @param id   Resource identifier
     * @param item Item
     */
    private static void register(String id, Item item) {
        Registry.register(Registry.ITEM, new Identifier(ImprovedFood.MOD_ID, id), item);
    }
}
