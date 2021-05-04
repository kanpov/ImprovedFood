package com.redgrapefruit.improvedfood.item;

import com.redgrapefruit.improvedfood.ImprovedFood;
import com.redgrapefruit.improvedfood.core.data.FoodCategory;
import com.redgrapefruit.improvedfood.core.data.FoodConfig;
import com.redgrapefruit.improvedfood.core.session.FoodState;
import com.redgrapefruit.improvedfood.registry.ItemGroupRegistry;
import com.redgrapefruit.redcore.util.Utilities;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

/**
 * An overdue variant of a {@link FoodItem}
 */
public class OverdueFoodItem extends FoodItem {
    /**
     * Constructs a non-native instance of an overdue variant
     *
     * @param config {@link FoodConfig}
     */
    public OverdueFoodItem(FoodConfig config) {
        super(config, ItemGroupRegistry.OVERDUE_FOOD, () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();

            // Hunger property
            builder.hunger(config.getCategory().getBaseHunger() + config.getHunger() - 2);
            // Meat property
            if (config.getCategory() == FoodCategory.MEAT) {
                builder.meat();
            }
            // Snack property (is a snack if hunger is less than 3)
            if (config.getCategory().getBaseHunger() + config.getHunger() < 3) {
                builder.snack();
            }
            // Saturation modifier property
            builder.saturationModifier((config.getCategory().getBaseSaturation() + config.getSaturationModifier()) / 2f);
            // Effects
            builder.statusEffect(
                    new StatusEffectInstance(
                            StatusEffects.NAUSEA,
                            ImprovedFood.RANDOM.nextInt(250) + 50,
                            ImprovedFood.RANDOM.nextInt(3) + 1),
                    0.9f
            );
            builder.statusEffect(
                    new StatusEffectInstance(
                            StatusEffects.BLINDNESS,
                            ImprovedFood.RANDOM.nextInt(150) + 50,
                            ImprovedFood.RANDOM.nextInt(2) + 1),
                    0.7f
            );
            builder.statusEffect(
                    new StatusEffectInstance(
                            StatusEffects.SLOWNESS,
                            ImprovedFood.RANDOM.nextInt(100) + 50,
                            ImprovedFood.RANDOM.nextInt(2) + 1),
                    0.45f
            );

            return builder.build();
        });

        setState(FoodState.OVERDUE);
        overrideEffects();
    }

    /**
     * Constructs a native instance of an overdue variant
     *
     * @param config {@link FoodConfig}
     * @param origin Original {@link FoodComponent}
     */
    public OverdueFoodItem(FoodConfig config, FoodComponent origin) {
        super(config, ItemGroupRegistry.OVERDUE_FOOD, () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();

            // Copy everything from origin first
            Utilities.overrideComponentValues(origin, builder, 0.25f, 1);
            // Effects
            builder.statusEffect(
                    new StatusEffectInstance(
                            StatusEffects.NAUSEA,
                            ImprovedFood.RANDOM.nextInt(250) + 50,
                            ImprovedFood.RANDOM.nextInt(3) + 1),
                    0.9f
            );
            builder.statusEffect(
                    new StatusEffectInstance(
                            StatusEffects.BLINDNESS,
                            ImprovedFood.RANDOM.nextInt(150) + 50,
                            ImprovedFood.RANDOM.nextInt(2) + 1),
                    0.7f
            );
            builder.statusEffect(
                    new StatusEffectInstance(
                            StatusEffects.SLOWNESS,
                            ImprovedFood.RANDOM.nextInt(100) + 50,
                            ImprovedFood.RANDOM.nextInt(2) + 1),
                    0.45f
            );

            return builder.build();
        });

        setState(FoodState.OVERDUE);
        overrideEffects();
    }
}
