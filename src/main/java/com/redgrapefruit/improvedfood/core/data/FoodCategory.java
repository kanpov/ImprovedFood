package com.redgrapefruit.improvedfood.core.data;

/**
 * A category of a type of food.<br>
 * Depending on the category some effects from the {@link FoodConfig} will be applied, and the others will not
 */
public enum FoodCategory {
    MEAT(4,
            1.6f,
            "Meat",
            true,
            false,
            true,
            "Trusty old meat."),

    FRUIT(2,
            1.2f,
            "Fruit",
            false,
            true,
            true,
            "Sweet, juicy fruit."),

    VEGETABLE(2,
            1.3f,
            "Vegetable",
            false,
            true,
            true,
            "Extremely healthy vegetable."),

    BERRIES(1,
            0.6f,
            "Berries",
            false,
            true,
            false,
            "Small and tasty berries."),

    FISH(3,
            1.25f,
            "Fish",
            false,
            true,
            true,
            "Nice and yummy fish."),

    HARMFUL(1,
            0.5f,
            "Harmful",
            true,
            true,
            false,
            "Just why do you eat these things?"),

    COOKED(3,
            0.65f,
            "Cooked Food",
            false,
            true,
            true,
            "Bakery, soup etc."),

    MISC(2,
            0.75f,
            "Miscellaneous",
            false,
            true,
            true,
            "The food that doesn't fit in regular categories.");

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
    /**
     * Can this food type rot
     */
    private final boolean canRot;
    /**
     * Can this food type overdue
     */
    private final boolean canOverdue;
    /**
     * Can this food type be contained in a fridge
     */
    private final boolean canBePutInFridge;
    /**
     * Visual description of this category
     */
    private final String description;

    FoodCategory(int baseHunger, float baseSaturation, String displayName, boolean canRot, boolean canOverdue, boolean canBePutInFridge, String description) {
        this.baseHunger = baseHunger;
        this.baseSaturation = baseSaturation;
        this.displayName = displayName;
        this.canRot = canRot;
        this.canOverdue = canOverdue;
        this.canBePutInFridge = canBePutInFridge;
        this.description = description;
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

    public boolean canRot() {
        return canRot;
    }

    public boolean canOverdue() {
        return canOverdue;
    }

    public boolean canBePutInFridge() {
        return canBePutInFridge;
    }

    public String getDescription() {
        return description;
    }
}
