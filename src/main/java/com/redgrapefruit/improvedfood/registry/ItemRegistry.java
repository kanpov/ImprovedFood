package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import com.redgrapefruit.improvedfood.item.RottenFoodItem;
import com.redgrapefruit.improvedfood.item.SaltItem;
import com.redgrapefruit.improvedfood.item.SaltedFoodItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers mod items into Minecraft.
 */
public class ItemRegistry {
    // Rotten variants
    public static final RottenFoodItem PORKCHOP_ROTTEN = new RottenFoodItem(ConfigRegistry.PORKCHOP);

    // Overdue variants

    // Salted variants
    public static final SaltedFoodItem PORKCHOP_SALTED = new SaltedFoodItem(ConfigRegistry.PORKCHOP);

    // Miscellaneous
    public static final SaltItem SALT = new SaltItem();

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
