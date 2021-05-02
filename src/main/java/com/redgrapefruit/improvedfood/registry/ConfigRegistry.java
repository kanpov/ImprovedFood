package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.core.FoodCategory;
import com.redgrapefruit.improvedfood.core.FoodConfig;

/**
 * A registry for {@link FoodConfig}'s.<br>
 * Acts as a storage system until configs are written in a custom JSON resource and doesn't actually register anything
 */
public class ConfigRegistry {
    // Vanilla
    public static final FoodConfig PORKCHOP = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotState(75000)
            .rotSpeed(10)
            .fridgeEfficiency(5)
            .saltEfficiency(3)
            .build();
    public static final FoodConfig COOKED_PORKCHOP = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotState(125000)
            .rotSpeed(8)
            .fridgeEfficiency(6)
            .saltEfficiency(4)
            .build();
}
