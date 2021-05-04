package com.redgrapefruit.improvedfood.core.session;

import com.redgrapefruit.improvedfood.core.data.FoodConfig;
import com.redgrapefruit.improvedfood.item.FoodItem;

/**
 * A food state represents a state of a {@link FoodItem}.<br>
 * Depending on the state, some properties of the {@link FoodConfig} are enabled and others are disabled
 */
public enum FoodState {
    FRESH(true, true, true, "Fresh"),
    ROTTEN(false, false, false, "Rotten"),
    OVERDUE(false, false, false, "Overdue"),
    SALTED(true, true, false, "Salted");

    /**
     * Does this state display rot
     */
    private final boolean displayRot;
    /**
     * Does this state display overdue
     */
    private final boolean displayOverdue;
    /**
     * Does this state display isInFridge and canBePutInFridge properties
     */
    private final boolean displayFridgeProperties;
    /**
     * The tooltip display name of this state
     */
    private final String displayName;

    FoodState(boolean displayRot, boolean displayOverdue, boolean displayFridgeProperties, String displayName) {
        this.displayRot = displayRot;
        this.displayOverdue = displayOverdue;
        this.displayFridgeProperties = displayFridgeProperties;
        this.displayName = displayName;
    }

    public boolean doesDisplayRot() {
        return displayRot;
    }

    public boolean doesDisplayOverdue() {
        return displayOverdue;
    }

    public boolean doesDisplayFridgeProperties() {
        return displayFridgeProperties;
    }

    public String getDisplayName() {
        return displayName;
    }
}
