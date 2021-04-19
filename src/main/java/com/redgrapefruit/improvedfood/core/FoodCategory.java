package com.redgrapefruit.improvedfood.core;

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
		 true,
		 "Trusty old meat. Fills your belly really well"),
		 
    FRUIT(2,
	      1.2f,
		  "Fruit",
		  false,
		  true,
		  true,
		  false,
		  "Sweet, juicy fruit. Important for a good diet"),
		  
    VEGETABLE(2,
			  1.3f,
			  "Vegetable",
			  false,
			  true,
			  true,
			  false,
			  "Extremely healthy vegetable. Who doesn't like cucumbers and tomatoes?"),
			  
    BERRIES(1,
        	0.6f,
			"Berries",
			false,
			true,
			false,
			false,
			"Small and tasty berries. Very cheap but not very nutritious");

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
     * Can this food type be salted
     */
    private final boolean canBeSalted;
    /**
     * Visual description of this category
     */
    private final String description;

    FoodCategory(int baseHunger, float baseSaturation, String displayName, boolean canRot, boolean canOverdue, boolean canBePutInFridge, boolean canBeSalted, String description) {
        this.baseHunger = baseHunger;
        this.baseSaturation = baseSaturation;
        this.displayName = displayName;
        this.canRot = canRot;
        this.canOverdue = canOverdue;
        this.canBePutInFridge = canBePutInFridge;
        this.canBeSalted = canBeSalted;
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

    public boolean canBeSalted() {
        return canBeSalted;
    }

    public String getDescription() {
        return description;
    }
}
