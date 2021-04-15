package com.redgrapefruit.improvedfood.util;

/**
 * A utility for builder properties which should be tracked and logged
 */
public class BuilderProperty<T> {
    /**
     * The inner value
     */
    private T value;
    /**
     * Has this property already been defined
     */
    private boolean isDefined;

    /**
     * The name of the builder to which this property belongs
     */
    private final String builderName;

    /**
     * The name of this property for error output
     */
    private final String propertyName;

    public BuilderProperty(String builderName, String propertyName) {
        this.value = null;
        this.isDefined = false;
        this.builderName = builderName;
        this.propertyName = propertyName;
    }

    /**
     * Sets this property and marks it as defined
     * @param value New value
     */
    public void set(T value) {
        if (isDefined) {
            Logging.error("Builder " + builderName + " property " + propertyName + " has already been set");
            return;
        }

        this.value = value;
        this.isDefined = true;
    }

    /**
     * Returns current value of this property
     * @return Property value; Will log an error if undefined
     */
    public T get() {
        if (!isDefined) {
            Logging.error("Builder " + builderName + " property " + propertyName + " hasn't been defined; This error will be followed by NullPointerExceptions");
            return null;
        }

        return value;
    }

    /**
     * Returns the value without any checks.
     * @return Property value without checks
     */
    public T getUnchecked() {
        return value;
    }
}
