package com.redgrapefruit.improvedfood.common.util;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;

/**
 * General-purpose set of small, but sometimes helpful utilities
 */
public class Utilities {
    /**
     * Overrides ALL {@link FoodComponent} values from given {@link FoodComponent} and puts them into a {@link FoodComponent.Builder}
     *
     * @param origin  Original {@link FoodComponent}
     * @param builder {@link FoodComponent.Builder} instance because Mojank decided to make {@link FoodComponent}s immutable
     */
    public static void overrideComponentValues(FoodComponent origin, FoodComponent.Builder builder, float saturationModifierDecrease, int hungerDecrease) {
        // Standard values
        builder.hunger(origin.getHunger() - hungerDecrease);
        builder.saturationModifier(origin.getSaturationModifier() - saturationModifierDecrease);
        // Effects
        for (Pair<StatusEffectInstance, Float> effectPair : origin.getStatusEffects()) {
            builder.statusEffect(effectPair.getFirst(), effectPair.getSecond());
        }
        // Boolean values
        if (origin.isMeat()) builder.meat();
        if (origin.isAlwaysEdible()) builder.alwaysEdible();
        if (origin.isSnack()) builder.snack();
    }
}
