package com.redgrapefruit.improvedfood.core;

import com.redgrapefruit.improvedfood.util.BuilderProperty;
import net.minecraft.entity.effect.StatusEffect;

/**
 * A config of a unique effect type
 */
public class FoodEffectConfig {
    /**
     * The status effect itself
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
     * The chance of the food being applied.<br>
     * Only used when {@link #isAlwaysApplied}=false
     */
    private final int chance;

    private FoodEffectConfig(StatusEffect statusEffect, int duration, int amplifier, boolean isPermanent, boolean isAlwaysApplied, int chance) {
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

    public int getChance() {
        return chance;
    }

    public static class Builder {
        private static final String BUILDER_NAME = "FoodEffectConfig.Builder";

        private final BuilderProperty<StatusEffect> statusEffect;
        private final BuilderProperty<Integer> duration;
        private final BuilderProperty<Integer> amplifier;
        private final BuilderProperty<Boolean> isPermanent;
        private final BuilderProperty<Boolean> isAlwaysApplied;
        private final BuilderProperty<Integer> chance;

        public Builder() {
            statusEffect = new BuilderProperty<>(BUILDER_NAME, "statusEffect");
            duration = new BuilderProperty<>(BUILDER_NAME, "duration");
            amplifier = new BuilderProperty<>(BUILDER_NAME, "amplifier");
            isPermanent = new BuilderProperty<>(BUILDER_NAME, "isPermanent");
            isAlwaysApplied = new BuilderProperty<>(BUILDER_NAME, "isAlwaysApplied");
            chance = new BuilderProperty<>(BUILDER_NAME, "chance");
        }

        public Builder statusEffect(StatusEffect statusEffect) {
            this.statusEffect.set(statusEffect);
            return this;
        }

        public Builder duration(int duration) {
            this.duration.set(duration);
            return this;
        }

        public Builder amplifier(int amplifier) {
            this.amplifier.set(amplifier);
            return this;
        }

        public Builder isPermanent(boolean isPermanent) {
            this.isPermanent.set(isPermanent);
            return this;
        }

        public Builder isAlwaysApplied(boolean isAlwaysApplied) {
            this.isAlwaysApplied.set(isAlwaysApplied);
            return this;
        }

        public Builder chance(int chance) {
            this.chance.set(chance);
            return this;
        }

        public FoodEffectConfig build() {
            return new FoodEffectConfig(
                    statusEffect.get(),
                    duration.get(),
                    amplifier.get(),
                    isPermanent.get(),
                    isAlwaysApplied.get(),
                    chance.get()
            );
        }
    }
}
