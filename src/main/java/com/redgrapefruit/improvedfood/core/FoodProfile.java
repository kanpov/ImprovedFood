package com.redgrapefruit.improvedfood.core;

/**
 * A profile with temporary data about a food item.<br>
 * TODO: Serialize profiles using CardinalComponentsAPI
 */
public class FoodProfile {
    /**
     * Current rot progress
     */
    private int rotProgress;
    /**
     * Current overdue progress
     */
    private int overdueProgress;
    /**
     * Is salted
     */
    private boolean isSalted;
    /**
     * Is stored in a fridge
     */
    private boolean isInFridge;
    /**
     * Config of this food item
     */
    private final FoodConfig config;
    /**
     * Category of this food item obtained through {@link FoodConfig#getCategory()}
     */
    private final FoodCategory category;

    public FoodProfile(FoodConfig config) {
        this.rotProgress = 0;
        this.overdueProgress = 0;
        this.isSalted = false;
        this.isInFridge = false;
        this.config = config;
        this.category = config.getCategory();
    }

    /**
     * Updates rot or/and overdue progress depending on the food category
     */
    public void update() {
        if (category.canRot()) applyRot();
        if (category.canOverdue()) applyOverdue();
    }

    /**
     * Applies rot effect and decreases it if the food is put in a fridge and/or salted
     */
    private void applyRot() {
        // Base
        rotProgress += config.getRotSpeed();
        // Fridge
        if (isInFridge) rotProgress -= config.getFridgeEfficiency();
        // Salt
        if (isSalted) rotProgress -= config.getSaltEfficiency();
    }

    /**
     * Applies overdue effect and decreases it if the food is put in a fridge
     */
    private void applyOverdue() {
        // Base
        overdueProgress += config.getOverdueSpeed();
        // Fridge
        if (isInFridge) overdueProgress -= config.getFridgeEfficiency();
    }

    public void toggleSalted(boolean isSalted) {
        this.isSalted = isSalted;
    }

    public void toggleInFridge(boolean isInFridge) {
        this.isInFridge = isInFridge;
    }

    public int getRotProgress() {
        return rotProgress;
    }

    public int getOverdueProgress() {
        return overdueProgress;
    }

    public boolean isSalted() {
        return isSalted;
    }

    public boolean isInFridge() {
        return isInFridge;
    }
}
