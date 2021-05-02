package com.redgrapefruit.improvedfood.item;

import com.redgrapefruit.improvedfood.core.FoodCategory;
import com.redgrapefruit.improvedfood.core.FoodConfig;
import com.redgrapefruit.improvedfood.core.FoodState;
import com.redgrapefruit.improvedfood.registry.ItemGroupRegistry;
import net.minecraft.item.FoodComponent;

/**
 * A salted variant of a {@link FoodItem}
 */
public class SaltedFoodItem extends FoodItem {
    public SaltedFoodItem(FoodConfig config) {
        super(config, ItemGroupRegistry.SALTED_FOOD, () -> {
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

            return builder.build();
        });

        setState(FoodState.SALTED);
        salted();
    }
}
