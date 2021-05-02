package com.redgrapefruit.improvedfood.core;

import net.minecraft.entity.effect.StatusEffect;

/**
 * A config of a unique effect type
 */
public class FoodEffectConfig {
    /**
     * The {@link StatusEffect} itself
     */
    private final StatusEffect statusEffect;

    /**
     * The duration of this effect
     */
    private final int duration;

    /**
     * The amplifier of this effect
     */
    private final int amplifier;

    /**
     * Whether or not this effect will be permanently applied to the player
     */
    private final boolean isPermanent;

    /**
     * Whether or not this effect will always be applied when the food is eaten
     */
    private final boolean isAlwaysApplied;

    /**
     * The chance of the food being applied on a scale from 0.0f to 1.0f<br>
     * Only used when {@link #isAlwaysApplied}=false
     */
    private final float chance;

    private FoodEffectConfig(StatusEffect statusEffect, int duration, int amplifier, boolean isPermanent, boolean isAlwaysApplied, float chance) {
        this.statusEffect = statusEffect;
        this.duration = duration;
        this.amplifier = amplifier;
        this.isPermanent = isPermanent;
        this.isAlwaysApplied = isAlwaysApplied;
        this.chance = chance;
    }

    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public int getDuration() {
        return duration;
    }

    public int getAmplifier() {
        return amplifier;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public boolean isAlwaysApplied() {
        return isAlwaysApplied;
    }

    public float getChance() {
        return chance;
    }

    /**
     * A builder for {@link FoodEffectConfig}s
     */
    public static class Builder {
        private StatusEffect statusEffect;
        private int duration;
        private int amplifier;
        private boolean isPermanent;
        private boolean isAlwaysApplied;
        private float chance;

        public Builder statusEffect(StatusEffect statusEffect) {
            this.statusEffect = statusEffect;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder amplifier(int amplifier) {
            this.amplifier = amplifier;
            return this;
        }

        public Builder isPermanent(boolean isPermanent) {
            this.isPermanent = isPermanent;
            // Also set the duration to the absolute maximum to ensure that the effect stays permanent
            this.duration = Integer.MAX_VALUE;

            return this;
        }

        public Builder isAlwaysApplied(boolean isAlwaysApplied) {
            this.isAlwaysApplied = isAlwaysApplied;
            return this;
        }

        public Builder chance(float chance) {
            this.chance = chance;
            return this;
        }

        public FoodEffectConfig build() {
            return new FoodEffectConfig(statusEffect, duration, amplifier, isPermanent, isAlwaysApplied, chance);
        }
    }
}
