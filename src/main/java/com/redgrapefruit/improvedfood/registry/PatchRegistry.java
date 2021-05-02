package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.core.FoodConfig;
import com.redgrapefruit.improvedfood.core.FoodProfile;
import com.redgrapefruit.improvedfood.item.OverdueFoodItem;
import com.redgrapefruit.improvedfood.item.RottenFoodItem;
import com.redgrapefruit.improvedfood.item.SaltedFoodItem;
import com.redgrapefruit.improvedfood.util.ItemMixinAccess;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

/**
 * This registry patches vanilla food to apply mod's special food properties to it
 */
public class PatchRegistry {
    public static void run() {
        register(Items.PORKCHOP, ConfigRegistry.PORKCHOP, ItemRegistry.PORKCHOP_ROTTEN, ItemRegistry.PORKCHOP_SALTED);
    }

    /**
     * "Registers" the base properties of an item (no variants) as explained in the class javadoc above (from point number 2 to 4)
     *
     * @param item   Source item
     * @param config {@link FoodConfig}
     */
    private static ItemMixinAccess register(Item item, FoodConfig config) {
        // Cast the item to duck interface
        ItemMixinAccess access = (ItemMixinAccess) item;
        // Activate and assign fields
        access.activate();
        access.setConfig(config);
        access.setProfile(new FoodProfile(config)); // TODO: Replace with deserialized profile instead of creating a new profile every launch of the game

        return access;
    }

    private static void register(Item item, FoodConfig config, RottenFoodItem rottenVariant, SaltedFoodItem saltedVariant) {
        ItemMixinAccess access = register(item, config);
        access.setRottenVariant(rottenVariant);
        access.setSaltedVariant(saltedVariant);
    }

    private static void register(Item item, FoodConfig config, OverdueFoodItem overdueVariant) {
        ItemMixinAccess access = register(item, config);
        access.setOverdueVariant(overdueVariant);
    }

    private static void register(Item item, FoodConfig config, RottenFoodItem rottenVariant, SaltedFoodItem saltedVariant, OverdueFoodItem overdueVariant) {
        ItemMixinAccess access = register(item, config);
        access.setRottenVariant(rottenVariant);
        access.setSaltedVariant(saltedVariant);
        access.setOverdueVariant(overdueVariant);
    }
}