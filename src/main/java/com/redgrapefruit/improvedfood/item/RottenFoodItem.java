package com.redgrapefruit.improvedfood.item;

import com.redgrapefruit.improvedfood.ImprovedFood;
import com.redgrapefruit.improvedfood.core.FoodCategory;
import com.redgrapefruit.improvedfood.core.FoodConfig;
import com.redgrapefruit.improvedfood.registry.ItemGroupRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

/**
 * A rotten variant of a {@link FoodItem}
 */
public class RottenFoodItem extends FoodItem {
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

        setState("Rotten");
        overrideEffects();
    }
}
