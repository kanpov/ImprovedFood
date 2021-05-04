package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import com.redgrapefruit.improvedfood.item.OverdueFoodItem;
import com.redgrapefruit.improvedfood.item.RottenFoodItem;
import com.redgrapefruit.improvedfood.item.SaltItem;
import com.redgrapefruit.improvedfood.item.SaltedFoodItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers mod items into Minecraft.
 */
public class ItemRegistry {
    // Rotten variants
    public static final RottenFoodItem ROTTEN_PORKCHOP = new RottenFoodItem(ConfigRegistry.PORKCHOP, FoodComponents.PORKCHOP);
    public static final RottenFoodItem ROTTEN_COOKED_PORKCHOP = new RottenFoodItem(ConfigRegistry.COOKED_PORKCHOP, FoodComponents.COOKED_PORKCHOP);
    public static final RottenFoodItem ROTTEN_BEEF = new RottenFoodItem(ConfigRegistry.BEEF, FoodComponents.BEEF);
    public static final RottenFoodItem ROTTEN_COOKED_BEEF = new RottenFoodItem(ConfigRegistry.COOKED_BEEF, FoodComponents.COOKED_BEEF);
    public static final RottenFoodItem ROTTEN_CHICKEN = new RottenFoodItem(ConfigRegistry.CHICKEN, FoodComponents.CHICKEN);
    public static final RottenFoodItem ROTTEN_COOKED_CHICKEN = new RottenFoodItem(ConfigRegistry.COOKED_CHICKEN, FoodComponents.COOKED_CHICKEN);
    public static final RottenFoodItem ROTTEN_MUTTON = new RottenFoodItem(ConfigRegistry.MUTTON, FoodComponents.MUTTON);
    public static final RottenFoodItem ROTTEN_COOKED_MUTTON = new RottenFoodItem(ConfigRegistry.COOKED_MUTTON, FoodComponents.COOKED_MUTTON);
    public static final RottenFoodItem ROTTEN_RABBIT = new RottenFoodItem(ConfigRegistry.RABBIT, FoodComponents.RABBIT);
    public static final RottenFoodItem ROTTEN_COOKED_RABBIT = new RottenFoodItem(ConfigRegistry.COOKED_RABBIT, FoodComponents.COOKED_RABBIT);

    // Overdue variants
    public static final OverdueFoodItem OVERDUE_SALMON = new OverdueFoodItem(ConfigRegistry.SALMON, FoodComponents.SALMON);
    public static final OverdueFoodItem OVERDUE_COOKED_SALMON = new OverdueFoodItem(ConfigRegistry.COOKED_SALMON, FoodComponents.COOKED_SALMON);
    public static final OverdueFoodItem OVERDUE_COD = new OverdueFoodItem(ConfigRegistry.COD, FoodComponents.COD);
    public static final OverdueFoodItem OVERDUE_COOKED_COD = new OverdueFoodItem(ConfigRegistry.COOKED_COD, FoodComponents.COOKED_COD);
    public static final OverdueFoodItem OVERDUE_APPLE = new OverdueFoodItem(ConfigRegistry.APPLE, FoodComponents.APPLE);
    public static final OverdueFoodItem OVERDUE_GOLDEN_APPLE = new OverdueFoodItem(ConfigRegistry.GOLDEN_APPLE, FoodComponents.GOLDEN_APPLE);
    public static final OverdueFoodItem OVERDUE_CARROT = new OverdueFoodItem(ConfigRegistry.CARROT, FoodComponents.CARROT);
    public static final OverdueFoodItem OVERDUE_GOLDEN_CARROT = new OverdueFoodItem(ConfigRegistry.GOLDEN_CARROT, FoodComponents.GOLDEN_CARROT);
    public static final OverdueFoodItem OVERDUE_POTATO = new OverdueFoodItem(ConfigRegistry.POTATO, FoodComponents.POTATO);

    // Salted variants
    public static final SaltedFoodItem SALTED_PORKCHOP = new SaltedFoodItem(ConfigRegistry.PORKCHOP, FoodComponents.PORKCHOP);
    public static final SaltedFoodItem SALTED_COOKED_PORKCHOP = new SaltedFoodItem(ConfigRegistry.COOKED_PORKCHOP, FoodComponents.COOKED_PORKCHOP);
    public static final SaltedFoodItem SALTED_BEEF = new SaltedFoodItem(ConfigRegistry.BEEF, FoodComponents.BEEF);
    public static final SaltedFoodItem SALTED_COOKED_BEEF = new SaltedFoodItem(ConfigRegistry.COOKED_BEEF, FoodComponents.COOKED_BEEF);
    public static final SaltedFoodItem SALTED_CHICKEN = new SaltedFoodItem(ConfigRegistry.CHICKEN, FoodComponents.CHICKEN);
    public static final SaltedFoodItem SALTED_COOKED_CHICKEN = new SaltedFoodItem(ConfigRegistry.COOKED_CHICKEN, FoodComponents.COOKED_CHICKEN);
    public static final SaltedFoodItem SALTED_MUTTON = new SaltedFoodItem(ConfigRegistry.MUTTON, FoodComponents.MUTTON);
    public static final SaltedFoodItem SALTED_COOKED_MUTTON = new SaltedFoodItem(ConfigRegistry.COOKED_MUTTON, FoodComponents.COOKED_MUTTON);
    public static final SaltedFoodItem SALTED_RABBIT = new SaltedFoodItem(ConfigRegistry.RABBIT, FoodComponents.RABBIT);
    public static final SaltedFoodItem SALTED_COOKED_RABBIT = new SaltedFoodItem(ConfigRegistry.COOKED_RABBIT, FoodComponents.COOKED_RABBIT);
    public static final SaltedFoodItem SALTED_SALMON = new SaltedFoodItem(ConfigRegistry.SALMON, FoodComponents.SALMON);
    public static final SaltedFoodItem SALTED_COOKED_SALMON = new SaltedFoodItem(ConfigRegistry.COOKED_SALMON, FoodComponents.COOKED_SALMON);
    public static final SaltedFoodItem SALTED_COD = new SaltedFoodItem(ConfigRegistry.COD, FoodComponents.COD);
    public static final SaltedFoodItem SALTED_COOKED_COD = new SaltedFoodItem(ConfigRegistry.COOKED_COD, FoodComponents.COOKED_COD);
    public static final SaltedFoodItem SALTED_POTATO = new SaltedFoodItem(ConfigRegistry.POTATO, FoodComponents.POTATO);

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
        register("rotten_mutton", ROTTEN_MUTTON);
        register("rotten_cooked_mutton", ROTTEN_COOKED_MUTTON);
        register("rotten_rabbit", ROTTEN_RABBIT);
        register("rotten_cooked_rabbit", ROTTEN_COOKED_RABBIT);
        register("overdue_salmon", OVERDUE_SALMON);
        register("overdue_cooked_salmon", OVERDUE_COOKED_SALMON);
        register("overdue_cod", OVERDUE_COD);
        register("overdue_cooked_cod", OVERDUE_COOKED_COD);
        register("overdue_apple", OVERDUE_APPLE);
        register("overdue_golden_apple", OVERDUE_GOLDEN_APPLE);
        register("overdue_carrot", OVERDUE_CARROT);
        register("overdue_golden_carrot", OVERDUE_GOLDEN_CARROT);
        register("overdue_potato", OVERDUE_POTATO);
        register("salted_porkchop", SALTED_PORKCHOP);
        register("salted_cooked_porkchop", SALTED_COOKED_PORKCHOP);
        register("salted_beef", SALTED_BEEF);
        register("salted_cooked_beef", SALTED_COOKED_BEEF);
        register("salted_chicken", SALTED_CHICKEN);
        register("salted_cooked_chicken", SALTED_COOKED_CHICKEN);
        register("salted_mutton", SALTED_MUTTON);
        register("salted_cooked_mutton", SALTED_COOKED_MUTTON);
        register("salted_rabbit", SALTED_RABBIT);
        register("salted_cooked_rabbit", SALTED_COOKED_RABBIT);
        register("salted_salmon", SALTED_SALMON);
        register("salted_cooked_salmon", SALTED_COOKED_SALMON);
        register("salted_cod", SALTED_COD);
        register("salted_cooked_cod", SALTED_COOKED_COD);
        register("salted_potato", SALTED_POTATO);
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
