package com.redgrapefruit.improvedfood.core;

/**
 * A category of a type of food.<br>
 * Depending on the category some effects from the {@link FoodConfig} will be applied, and the others will not
 */
public enum FoodCategory {
    MEAT(4, 1.2f, "Meat"),
    FRUIT(2, 0.8f, "Fruit"),
    VEGETABLE(2, 0.9f, "Vegetable"),
    BERRIES(1, 0.6f, "Berries");

    /**
     * Base hunger of this food type.<br>
     * Unique hunger will be added on top of this value.
     */
    private final int baseHunger;
    /**
     * Base saturation modifier of this food type.<br>
     * Unique saturation will be added on top of this value.
     */
    private final float baseSaturation;
    /**
     * How this food type will be displayed in tooltips.
     */
    private final String displayName;

    FoodCategory(int baseHunger, float baseSaturation, String displayName) {
        this.baseHunger = baseHunger;
        this.baseSaturation = baseSaturation;
        this.displayName = displayName;
    }

    public int getBaseHunger() {
        return baseHunger;
    }

    public float getBaseSaturation() {
        return baseSaturation;
    }

    public String getDisplayName() {
        return displayName;
    }
}
