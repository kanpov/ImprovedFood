package com.redgrapefruit.improvedfood.common.item;

import com.redgrapefruit.improvedfood.common.ImprovedFood;
import com.redgrapefruit.improvedfood.common.core.FoodCategory;
import com.redgrapefruit.improvedfood.common.core.FoodConfig;
import com.redgrapefruit.improvedfood.common.core.FoodState;
import com.redgrapefruit.improvedfood.common.registry.ItemGroupRegistry;
import com.redgrapefruit.redcore.util.Utilities;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

/**
 * A rotten variant of a {@link FoodItem}
 */
public class RottenFoodItem extends FoodItem {
    /**
     * Constructs a non-native instance of a rotten variant
     *
     * @param config {@link FoodConfig}
     */
    public RottenFoodItem(FoodConfig config) {
        super(config, ItemGroupRegistry.ROTTEN_FOOD, () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();

            // Hunger property
            builder.hunger(config.getCategory().getBaseHunger() + config.getHunger() - 3);
            // Meat property
            if (config.getCategory() == FoodCategory.MEAT) {
                builder.meat();
            }
            // Snack property (is a snack if hunger is less than 3)
            if (config.getCategory().getBaseHunger() + config.getHunger() < 3) {
                builder.snack();
            }
            // Saturation modifier property
            builder.saturationModifier((config.getCategory().getBaseSaturation() + config.getSaturationModifier()) / 1.5f);
            // Poison effect
            builder.statusEffect(
                    new StatusEffectInstance(
                            StatusEffects.POISON,
                            ImprovedFood.RANDOM.nextInt(250) + 50,
                            ImprovedFood.RANDOM.nextInt(3) + 1),
                    0.85f
            );

            return builder.build();
        });

        setState(FoodState.ROTTEN);
        overrideEffects();
    }

    /**
     * Constructs a native instance of a rotten variant
     *
     * @param config {@link FoodConfig}
     * @param origin Original {@link FoodComponent}
     */
    public RottenFoodItem(FoodConfig config, FoodComponent origin) {
        super(config, ItemGroupRegistry.ROTTEN_FOOD, () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();

            // Copy everything from origin first
            Utilities.overrideComponentValues(origin, builder, 0.3f, 1);
            // Poison effect
            builder.statusEffect(
                    new StatusEffectInstance(
                            StatusEffects.POISON,
                            ImprovedFood.RANDOM.nextInt(250) + 50,
                            ImprovedFood.RANDOM.nextInt(3) + 1),
                    0.85f
            );

            return builder.build();
        });

        setState(FoodState.ROTTEN);
        overrideEffects();
    }
}
