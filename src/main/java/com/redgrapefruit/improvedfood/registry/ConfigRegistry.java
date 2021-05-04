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
    public static final FoodConfig BEEF = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotState(100000)
            .rotSpeed(12)
            .fridgeEfficiency(7)
            .saltEfficiency(5)
            .build();
    public static final FoodConfig COOKED_BEEF = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotState(150000)
            .rotSpeed(10)
            .fridgeEfficiency(8)
            .saltEfficiency(6)
            .build();
    public static final FoodConfig CHICKEN = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotState(80000)
            .rotSpeed(9)
            .fridgeEfficiency(4)
            .saltEfficiency(3)
            .build();
    public static final FoodConfig COOKED_CHICKEN = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotState(115000)
            .rotSpeed(8)
            .fridgeEfficiency(6)
            .saltEfficiency(4)
            .build();
    public static final FoodConfig MUTTON = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotState(90000)
            .rotSpeed(9)
            .fridgeEfficiency(5)
            .saltEfficiency(3)
            .build();
    public static final FoodConfig COOKED_MUTTON = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotState(120000)
            .rotSpeed(8)
            .fridgeEfficiency(6)
            .saltEfficiency(4)
            .build();
    public static final FoodConfig RABBIT = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotState(70000)
            .rotSpeed(7)
            .fridgeEfficiency(2)
            .saltEfficiency(3)
            .build();
    public static final FoodConfig COOKED_RABBIT = new FoodConfig.Builder()
            .category(FoodCategory.MEAT)
            .rotSpeed(110000)
            .rotSpeed(6)
            .fridgeEfficiency(3)
            .saltEfficiency(4)
            .build();
}
