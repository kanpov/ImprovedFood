package com.redgrapefruit.improvedfood.core;

/**
 * Calculations regarding food
 */
public class FoodMath {
    /**
     * Calculates current rot
     * @param profile Food profile
     * @param config Food config
     * @return Rot value
     */
    public static int rot(FoodProfile profile, FoodConfig config) {
        int out = config.getRotSpeed();

        if (config.getCategory().canBePutInFridge() && profile.isInFridge()) {
            out -= config.getFridgeEfficiency();
        }
        if (config.getCategory().canBeSalted() && profile.isSalted()) {
            out -= config.getSaltEfficiency();
        }

        return out;
    }

    /**
     * Calculates current overdue
     * @param profile Food profile
     * @param config Food config
     * @return Overdue value
     */
    public static int overdue(FoodProfile profile, FoodConfig config) {
        int out = config.getOverdueSpeed();

        if (config.getCategory().canBePutInFridge() && profile.isInFridge()) {
            out -= config.getFridgeEfficiency();
        }

        return out;
    }
}