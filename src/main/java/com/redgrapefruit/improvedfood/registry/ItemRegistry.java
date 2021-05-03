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
    public static final RottenFoodItem ROTTEN_PORKCHOP = new RottenFoodItem(ConfigRegistry.PORKCHOP);
    public static final RottenFoodItem ROTTEN_COOKED_PORKCHOP = new RottenFoodItem(ConfigRegistry.COOKED_PORKCHOP);
    public static final RottenFoodItem ROTTEN_BEEF = new RottenFoodItem(ConfigRegistry.BEEF);
    public static final RottenFoodItem ROTTEN_COOKED_BEEF = new RottenFoodItem(ConfigRegistry.COOKED_BEEF);
    public static final RottenFoodItem ROTTEN_CHICKEN = new RottenFoodItem(ConfigRegistry.CHICKEN);
    public static final RottenFoodItem ROTTEN_COOKED_CHICKEN = new RottenFoodItem(ConfigRegistry.COOKED_CHICKEN);

    // Overdue variants

    // Salted variants
    public static final SaltedFoodItem SALTED_PORKCHOP = new SaltedFoodItem(ConfigRegistry.PORKCHOP);
    public static final SaltedFoodItem SALTED_COOKED_PORKCHOP = new SaltedFoodItem(ConfigRegistry.COOKED_PORKCHOP);
    public static final SaltedFoodItem SALTED_BEEF = new SaltedFoodItem(ConfigRegistry.BEEF);
    public static final SaltedFoodItem SALTED_COOKED_BEEF = new SaltedFoodItem(ConfigRegistry.COOKED_BEEF);
    public static final SaltedFoodItem SALTED_CHICKEN = new SaltedFoodItem(ConfigRegistry.CHICKEN);
    public static final SaltedFoodItem SALTED_COOKED_CHICKEN = new SaltedFoodItem(ConfigRegistry.COOKED_CHICKEN);

    // Miscellaneous
    public static final SaltItem SALT = new SaltItem();

    /**
     * Runs the registry code
     */
    public static void run() {
        register("salt", SALT);
        register("rotten_porkchop", ROTTEN_PORKCHOP);
        register("rotten_cooked_porkchop", ROTTEN_COOKED_PORKCHOP);
        register("rotten_beef", ROTTEN_BEEF);
        register("rotten_cooked_beef", ROTTEN_COOKED_BEEF);
        register("rotten_chicken", ROTTEN_CHICKEN);
        register("rotten_cooked_chicken", ROTTEN_COOKED_CHICKEN);
        register("salted_porkchop", SALTED_PORKCHOP);
        register("salted_cooked_porkchop", SALTED_COOKED_PORKCHOP);
        register("salted_beef", SALTED_BEEF);
        register("salted_cooked_beef", SALTED_COOKED_BEEF);
        register("salted_chicken", SALTED_CHICKEN);
        register("salted_cooked_chicken", SALTED_COOKED_CHICKEN);
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
