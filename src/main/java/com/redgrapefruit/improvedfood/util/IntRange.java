package com.redgrapefruit.improvedfood.util;

import com.redgrapefruit.improvedfood.ImprovedFood;

/**
 * A range of integers to randomly pick from
 */
public class IntRange {
    private final int min;
    private final int max;

    public IntRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Picks a random number from this range
     * @return Random number
     */
    public int pick() {
        int initial = max - min;

        return ImprovedFood.RANDOM.nextInt(initial) + min;
    }
}
