package com.redgrapefruit.improvedfood.common.item;

import com.redgrapefruit.improvedfood.common.core.FoodCategory;
import com.redgrapefruit.improvedfood.common.core.FoodConfig;
import com.redgrapefruit.improvedfood.common.core.FoodState;
import com.redgrapefruit.improvedfood.common.registry.ItemGroupRegistry;
import com.redgrapefruit.improvedfood.common.util.Utilities;
import net.minecraft.item.FoodComponent;

/**
 * A salted variant of a {@link FoodItem}
 */
public class SaltedFoodItem extends FoodItem {
    /**
     * Constructs a non-native instance of a salted variant
     *
     * @param config {@link FoodConfig}
     */
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

    /**
     * Constructs a native instance of a salted variant
     *
     * @param config {@link FoodConfig}
     * @param origin Original {@link FoodComponent}
     */
    public SaltedFoodItem(FoodConfig config, FoodComponent origin) {
        super(config, ItemGroupRegistry.SALTED_FOOD, () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();

            // Copy all values from origin
            Utilities.overrideComponentValues(origin, builder, 0, 0);

            return builder.build();
        });

        setState(FoodState.SALTED);
        salted();
    }
}
