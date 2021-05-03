package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.core.FoodConfig;
import com.redgrapefruit.improvedfood.core.FoodProfile;
import com.redgrapefruit.improvedfood.item.OverdueFoodItem;
import com.redgrapefruit.improvedfood.item.RottenFoodItem;
import com.redgrapefruit.improvedfood.util.ItemMixinAccess;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

/**
 * This registry patches vanilla food to apply mod's special food properties to it
 */
public class PatchRegistry {
    /**
     * Runs the registry code
     */
    public static void run() {
        register(Items.PORKCHOP, ConfigRegistry.PORKCHOP, ItemRegistry.PORKCHOP_ROTTEN);
        register(Items.COOKED_PORKCHOP, ConfigRegistry.COOKED_PORKCHOP, ItemRegistry.PORKCHOP_ROTTEN);
        register(Items.BEEF, ConfigRegistry.BEEF, ItemRegistry.BEEF_ROTTEN);
        register(Items.COOKED_BEEF, ConfigRegistry.COOKED_BEEF, ItemRegistry.COOKED_BEEF_ROTTEN);
    }

    /**
     * Registers the base properties of an item (no variants) to the mixin access
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

    /**
     * Registers the base properties with meat's variants to the mixin access
     *
     * @param item          Item
     * @param config        {@link FoodConfig}
     * @param rottenVariant Rotten variant
     */
    private static void register(Item item, FoodConfig config, RottenFoodItem rottenVariant) {
        ItemMixinAccess access = register(item, config);
        access.setRottenVariant(rottenVariant);
    }

    /**
     * Registers the base properties with non-meat's variants to the mixin access
     *
     * @param item           Item
     * @param config         {@link FoodConfig}
     * @param overdueVariant Overdue variant
     */
    private static void register(Item item, FoodConfig config, OverdueFoodItem overdueVariant) {
        ItemMixinAccess access = register(item, config);
        access.setOverdueVariant(overdueVariant);
    }

    /**
     * Registers the base properties with all variants to the mixin access
     *
     * @param item           Item
     * @param config         {@link FoodConfig}
     * @param rottenVariant  Rotten variant
     * @param overdueVariant Overdue variant
     */
    private static void register(Item item, FoodConfig config, RottenFoodItem rottenVariant, OverdueFoodItem overdueVariant) {
        ItemMixinAccess access = register(item, config);
        access.setRottenVariant(rottenVariant);
        access.setOverdueVariant(overdueVariant);
    }
}
