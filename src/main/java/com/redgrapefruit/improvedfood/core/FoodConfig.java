package com.redgrapefruit.improvedfood.core;

import com.redgrapefruit.improvedfood.util.BuilderProperty;

import java.util.Set;
import java.util.HashSet;

/**
 * A food config contains all unique information about a type of food.
 */
public class FoodConfig {
    // FoodComponent properties
    /**
     * How many hunger bars this food will fill
     */
    private final int hunger;
    /**
     * How long will hunger bars acquired from eating this food last
     */
    private final float saturationModifier;

    // Unique properties
    /**
     * At what point in the rot counter the item is considered rotten
     */
    private final int rotState;
    /**
     * At what speed will the rot process go
     */
    private final int rotSpeed;
    /**
     * At what point in the overdue counter the item is considered overdue
     */
    private final int overdueState;
    /**
     * At what speed will the overdue process go
     */
    private final int overdueSpeed;
    /**
     * For how many ticks/second will the rot process be slowed down when the food is salted
     */
    private final int saltEfficiency;
    /**
     * For how many ticks/second will the rot and overdue processes be slowed down when the food is put in a fridge
     */
    private final int fridgeEfficiency;
    /**
     * The category of this food
     */
    private final FoodCategory category;
    /**
     * A {@link HashSet} containing all possible effects for this food item
     */
    private final Set<FoodEffectConfig> effects;

    private FoodConfig(int hunger, int saturationModifier, int rotState, int rotSpeed, int overdueState, int overdueSpeed, int saltEfficiency, int fridgeEfficiency, FoodCategory category, Set<FoodEffectConfig> effects) {
        this.hunger = hunger;
        this.saturationModifier = saturationModifier;
        this.rotState = rotState;
        this.rotSpeed = rotSpeed;
        this.overdueState = overdueState;
        this.overdueSpeed = overdueSpeed;
        this.saltEfficiency = saltEfficiency;
        this.fridgeEfficiency = fridgeEfficiency;
        this.category = category;
        this.effects = effects;
    }

    public int getHunger() {
        return hunger;
    }

    public float getSaturationModifier() {
        return saturationModifier;
    }

    public int getRotState() {
        return rotState;
    }

    public int getRotSpeed() {
        return rotSpeed;
    }

    public int getOverdueState() {
        return overdueState;
    }

    public int getOverdueSpeed() {
        return overdueSpeed;
    }

    public int getSaltEfficiency() {
        return saltEfficiency;
    }

    public int getFridgeEfficiency() {
        return fridgeEfficiency;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public Set<FoodEffectConfig> getEffects() {
        return effects;
    }

    public static class Builder {
        private static final String BUILDER_NAME = "FoodConfig.Builder";

        private final BuilderProperty<Integer> hunger;
        private final BuilderProperty<Integer> saturationModifier;
        private final BuilderProperty<Integer> rotState;
        private final BuilderProperty<Integer> rotSpeed;
        private final BuilderProperty<Integer> overdueState;
        private final BuilderProperty<Integer> overdueSpeed;
        private final BuilderProperty<Integer> saltEfficiency;
        private final BuilderProperty<Integer> fridgeEfficiency;
        private final BuilderProperty<FoodCategory> category;
        private final BuilderProperty<Set<FoodEffectConfig>> effects;

        public Builder() {
            hunger = new BuilderProperty<>(BUILDER_NAME, "hunger");
            saturationModifier = new BuilderProperty<>(BUILDER_NAME, "saturationModifier");
            rotState = new BuilderProperty<>(BUILDER_NAME, "rotState");
            rotSpeed = new BuilderProperty<>(BUILDER_NAME, "rotSpeed");
            overdueState = new BuilderProperty<>(BUILDER_NAME, "overdueState");
            overdueSpeed = new BuilderProperty<>(BUILDER_NAME, "overdueSpeed");
            saltEfficiency = new BuilderProperty<>(BUILDER_NAME, "saltEfficiency");
            fridgeEfficiency = new BuilderProperty<>(BUILDER_NAME, "fridgeEfficiency");
            category = new BuilderProperty<>(BUILDER_NAME, "category");
            effects = new BuilderProperty<>(BUILDER_NAME, "effects");
            effects.set(new HashSet<>()); // Instantiate the effects set
        }

        public Builder hunger(int hunger) {
            this.hunger.set(hunger);
            return this;
        }

        public Builder saturationModifier(int saturationModifier) {
            this.saturationModifier.set(saturationModifier);
            return this;
        }

        public Builder rotState(int rotState) {
            this.rotState.set(rotState);
            return this;
        }

        public Builder rotSpeed(int rotSpeed) {
            this.rotSpeed.set(rotSpeed);
            return this;
        }

        public Builder overdueState(int overdueState) {
            this.overdueState.set(overdueState);
            return this;
        }

        public Builder overdueSpeed(int overdueSpeed) {
            this.overdueSpeed.set(overdueSpeed);
            return this;
        }

        public Builder saltEfficiency(int saltEfficiency) {
            this.saltEfficiency.set(saltEfficiency);
            return this;
        }

        public Builder fridgeEfficiency(int fridgeEfficiency) {
            this.fridgeEfficiency.set(fridgeEfficiency);
            return this;
        }

        public Builder category(FoodCategory category) {
            this.category.set(category);
            return this;
        }

        public Builder effect(FoodEffectConfig effect) {
            this.effects.getUnchecked().add(effect);
            return this;
        }

        public FoodConfig build() {
            return new FoodConfig(
                    hunger.get(),
                    saturationModifier.get(),
                    rotState.get(),
                    rotSpeed.get(),
                    overdueState.get(),
                    overdueSpeed.get(),
                    saltEfficiency.get(),
                    fridgeEfficiency.get(),
                    category.get(),
                    effects.get()
            );
        }
    }
}
