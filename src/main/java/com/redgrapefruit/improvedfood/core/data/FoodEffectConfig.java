package com.redgrapefruit.improvedfood.core.data;

import com.redgrapefruit.improvedfood.util.IntRange;
import net.minecraft.entity.effect.StatusEffect;

import java.util.Optional;

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
     * An {@link IntRange} of durations applicable
     */
    private final Optional<IntRange> durationRange;

    /**
     * The amplifier of this effect
     */
    private final int amplifier;

    /**
     * An {@link IntRange} of amplifiers applicable
     */
    private final Optional<IntRange> amplifierRange;

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

    private FoodEffectConfig(StatusEffect statusEffect, int duration, Optional<IntRange> durationRange, int amplifier, Optional<IntRange> amplifierRange,  boolean isPermanent, boolean isAlwaysApplied, float chance) {
        this.statusEffect = statusEffect;
        this.duration = duration;
        this.durationRange = durationRange;
        this.amplifier = amplifier;
        this.amplifierRange = amplifierRange;
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

    public Optional<IntRange> getDurationRange() {
        return durationRange;
    }

    public Optional<IntRange> getAmplifierRange() {
        return amplifierRange;
    }

    /**
     * A builder for {@link FoodEffectConfig}s
     */
    public static class Builder {
        private StatusEffect statusEffect;
        private int duration;
        private Optional<IntRange> durationRange = Optional.empty();
        private int amplifier;
        private Optional<IntRange> amplifierRange = Optional.empty();
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

        public Builder rangedDuration(int min, int max) {
            this.durationRange = Optional.of(new IntRange(min, max));
            return this;
        }

        public Builder amplifier(int amplifier) {
            this.amplifier = amplifier;
            return this;
        }

        public Builder rangedAmplifier(int min, int max) {
            this.amplifierRange = Optional.of(new IntRange(min, max));
            return this;
        }

        public Builder isPermanent(boolean isPermanent) {
            this.isPermanent = isPermanent;
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
            return new FoodEffectConfig(statusEffect, duration, durationRange, amplifier, amplifierRange, isPermanent, isAlwaysApplied, chance);
        }
    }
}
