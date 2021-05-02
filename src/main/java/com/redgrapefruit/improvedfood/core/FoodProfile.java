package com.redgrapefruit.improvedfood.core;

import com.redgrapefruit.improvedfood.item.FoodItem;
import net.minecraft.world.World;

/**
 * A profile with temporary data about a {@link FoodItem}.<br>
 * TODO: Serialize profiles using CardinalComponentsAPI
 */
public class FoodProfile {
    /**
     * Minimum loss of ticks to recalculate the rot and/or overdue progress
     */
    public static final int MIN_TICK_LOSS = 20;
    /**
     * Current rot progress
     */
    private int rotProgress;
    /**
     * Current overdue progress
     */
    private int overdueProgress;
    /**
     * Is stored in a fridge
     */
    private boolean isInFridge;
    /**
     * Previous world tick
     */
    private long previousTick;
    /**
     * Is the profile initialized
     */
    private boolean isInitialized;

    public FoodProfile(FoodConfig config) {
        this.rotProgress = 0;
        this.overdueProgress = 0;
        this.isInFridge = false;
        this.isInitialized = false;
    }

    /**
     * Toggles the isInFridge flag on/off
     *
     * @param isInFridge New value
     */
    public void toggleInFridge(boolean isInFridge) {
        this.isInFridge = isInFridge;
    }

    /**
     * Resets the rot progress to 0
     */
    public void resetRotProgress() {
        rotProgress = 0;
    }

    /**
     * Increments rot progress by given value
     *
     * @param increment Incremented value
     */
    public void incrementRotProgress(int increment) {
        rotProgress += increment;
    }

    /**
     * Decrements rot progress by given value
     *
     * @param decrement Decremented value
     */
    public void decrementRotProgress(int decrement) {
        rotProgress -= decrement;
    }

    /**
     * Resets the overdue progress to 0
     */
    public void resetOverdueProgress() {
        overdueProgress = 0;
    }

    /**
     * Increments overdue progress by given value
     *
     * @param increment Incremented value
     */
    public void incrementOverdueProgress(int increment) {
        overdueProgress += increment;
    }

    /**
     * Updates the previousTick according to the world time
     *
     * @param world World instance
     */
    public void updatePreviousTick(World world) {
        previousTick = world.getTime();
    }

    /**
     * Marks the profile as initialized to stop doing any further setup
     */
    public void markInitialized() {
        isInitialized = true;
    }

    public int getRotProgress() {
        return rotProgress;
    }

    public int getOverdueProgress() {
        return overdueProgress;
    }

    public boolean isInFridge() {
        return isInFridge;
    }

    public long getPreviousTick() {
        return previousTick;
    }

    public void setPreviousTick(long previousTick) {
        this.previousTick = previousTick;
    }

    public boolean isInitialized() {
        return isInitialized;
    }
}
