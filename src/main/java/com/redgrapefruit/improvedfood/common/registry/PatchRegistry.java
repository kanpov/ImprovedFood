package com.redgrapefruit.improvedfood.common.registry;

import com.redgrapefruit.improvedfood.common.core.FoodConfig;
import com.redgrapefruit.improvedfood.common.core.FoodProfile;
import com.redgrapefruit.improvedfood.common.item.OverdueFoodItem;
import com.redgrapefruit.improvedfood.common.item.RottenFoodItem;
import com.redgrapefruit.improvedfood.common.util.ItemMixinAccess;
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
        patch(Items.PORKCHOP, ConfigRegistry.PORKCHOP, ItemRegistry.ROTTEN_PORKCHOP);
        patch(Items.COOKED_PORKCHOP, ConfigRegistry.COOKED_PORKCHOP, ItemRegistry.ROTTEN_PORKCHOP);
        patch(Items.BEEF, ConfigRegistry.BEEF, ItemRegistry.ROTTEN_BEEF);
        patch(Items.COOKED_BEEF, ConfigRegistry.COOKED_BEEF, ItemRegistry.ROTTEN_COOKED_BEEF);
        patch(Items.CHICKEN, ConfigRegistry.CHICKEN, ItemRegistry.ROTTEN_CHICKEN);
        patch(Items.COOKED_CHICKEN, ConfigRegistry.COOKED_CHICKEN, ItemRegistry.ROTTEN_COOKED_CHICKEN);
        patch(Items.MUTTON, ConfigRegistry.MUTTON, ItemRegistry.ROTTEN_MUTTON);
        patch(Items.COOKED_MUTTON, ConfigRegistry.COOKED_MUTTON, ItemRegistry.ROTTEN_COOKED_MUTTON);
        patch(Items.RABBIT, ConfigRegistry.RABBIT, ItemRegistry.ROTTEN_RABBIT);
        patch(Items.COOKED_RABBIT, ConfigRegistry.COOKED_RABBIT, ItemRegistry.ROTTEN_COOKED_RABBIT);
        patch(Items.SALMON, ConfigRegistry.SALMON, ItemRegistry.OVERDUE_SALMON);
        patch(Items.COOKED_SALMON, ConfigRegistry.COOKED_SALMON, ItemRegistry.OVERDUE_COOKED_SALMON);
        patch(Items.COD, ConfigRegistry.COD, ItemRegistry.OVERDUE_COD);
        patch(Items.COOKED_COD, ConfigRegistry.COOKED_COD, ItemRegistry.OVERDUE_COOKED_COD);
        patch(Items.APPLE, ConfigRegistry.APPLE, ItemRegistry.OVERDUE_APPLE);
        patch(Items.GOLDEN_APPLE, ConfigRegistry.GOLDEN_APPLE, ItemRegistry.OVERDUE_GOLDEN_APPLE);
        patch(Items.CARROT, ConfigRegistry.CARROT, ItemRegistry.OVERDUE_CARROT);
        patch(Items.GOLDEN_CARROT, ConfigRegistry.GOLDEN_CARROT, ItemRegistry.OVERDUE_GOLDEN_CARROT);
        patch(Items.POTATO, ConfigRegistry.POTATO, ItemRegistry.OVERDUE_POTATO);
        patch(Items.BAKED_POTATO, ConfigRegistry.BAKED_POTATO, ItemRegistry.OVERDUE_BAKED_POTATO);
        patch(Items.BEETROOT, ConfigRegistry.BEETROOT, ItemRegistry.OVERDUE_BEETROOT);
        patch(Items.BEETROOT_SOUP, ConfigRegistry.BEETROOT_SOUP, ItemRegistry.OVERDUE_BEETROOT_SOUP);
        patch(Items.BREAD, ConfigRegistry.BREAD, ItemRegistry.OVERDUE_BREAD);
        patch(Items.CHORUS_FRUIT, ConfigRegistry.CHORUS_FRUIT, ItemRegistry.OVERDUE_CHORUS_FRUIT);
        patch(Items.COOKIE, ConfigRegistry.COOKIE, ItemRegistry.OVERDUE_COOKIE);
        patch(Items.HONEY_BOTTLE, ConfigRegistry.HONEY_BOTTLE, ItemRegistry.OVERDUE_HONEY_BOTTLE);
        patch(Items.MELON_SLICE, ConfigRegistry.MELON_SLICE, ItemRegistry.OVERDUE_MELON_SLICE);
        patch(Items.MUSHROOM_STEW, ConfigRegistry.MUSHROOM_STEW, ItemRegistry.OVERDUE_MUSHROOM_STEW);
        patch(Items.PUMPKIN_PIE, ConfigRegistry.PUMPKIN_PIE, ItemRegistry.OVERDUE_PUMPKIN_PIE);
        patch(Items.RABBIT_STEW, ConfigRegistry.RABBIT_STEW, ItemRegistry.OVERDUE_RABBIT_STEW);
        patch(Items.SPIDER_EYE, ConfigRegistry.SPIDER_EYE, ItemRegistry.OVERDUE_SPIDER_EYE);
        patch(Items.SUSPICIOUS_STEW, ConfigRegistry.SUSPICIOUS_STEW, ItemRegistry.OVERDUE_SUSPICIOUS_STEW);
        patch(Items.SWEET_BERRIES, ConfigRegistry.SWEET_BERRIES, ItemRegistry.OVERDUE_SWEET_BERRIES);
        patch(Items.TROPICAL_FISH, ConfigRegistry.TROPICAL_FISH, ItemRegistry.OVERDUE_TROPICAL_FISH);
        patch(Items.CAKE, ConfigRegistry.CAKE, ItemRegistry.OVERDUE_CAKE);
    }

    /**
     * Patches the base properties of an item (no variants) to the mixin access
     *
     * @param item   Source item
     * @param config {@link FoodConfig}
     */
    private static ItemMixinAccess patch(Item item, FoodConfig config) {
        // Cast the item to duck interface
        ItemMixinAccess access = (ItemMixinAccess) item;
        // Activate and assign fields
        access.activate();
        access.setConfig(config);
        access.setProfile(new FoodProfile(config)); // TODO: Replace with deserialized profile instead of creating a new profile every launch of the game

        return access;
    }

    /**
     * Patches the base properties with meat's variants to the mixin access
     *
     * @param item          Item
     * @param config        {@link FoodConfig}
     * @param rottenVariant Rotten variant
     */
    private static void patch(Item item, FoodConfig config, RottenFoodItem rottenVariant) {
        ItemMixinAccess access = patch(item, config);
        access.setRottenVariant(rottenVariant);
    }

    /**
     * Patches the base properties with non-meat's variants to the mixin access
     *
     * @param item           Item
     * @param config         {@link FoodConfig}
     * @param overdueVariant Overdue variant
     */
    private static void patch(Item item, FoodConfig config, OverdueFoodItem overdueVariant) {
        ItemMixinAccess access = patch(item, config);
        access.setOverdueVariant(overdueVariant);
    }
}
