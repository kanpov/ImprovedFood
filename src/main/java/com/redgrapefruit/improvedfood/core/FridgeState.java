package com.redgrapefruit.improvedfood.core;

/**
 * Current fridge state.
 */
public enum FridgeState {
    /**
     * The item is currently in the fridge
     */
    IN_FRIDGE(true),
    /**
     * The item has left the fridge, but hasn't been compensated yet
     */
    NOT_COMPENSATED(false),
    /**
     * The item has left the fridge <b>and</b> has been compensated
     */
    NOT_IN_FRIDGE(false);

    private final boolean boolValue;

    FridgeState(boolean boolValue) {
        this.boolValue = boolValue;
    }

    public boolean getBoolValue() {
        return boolValue;
    }
}
