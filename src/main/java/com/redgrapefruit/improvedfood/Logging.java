package com.redgrapefruit.improvedfood;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utilities for logging
 */
public class Logging {
    /**
     * Is this a production build of the mod
     */
    private static final boolean PRODUCTION = false;

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Logs the message on debug level if this isn't a production build
     * @param text Debug text
     */
    public static void debug(String text) {
        if (!PRODUCTION) {
            LOGGER.log(Level.DEBUG, text);
        }
    }

    /**
     * Logs the message on info level
     * @param text Info text
     */
    public static void info(String text) {
        LOGGER.log(Level.INFO, text);
    }

    /**
     * Logs the message on warning level
     * @param text Warning text
     */
    public static void warning(String text) {
        LOGGER.log(Level.WARN, text);
    }

    /**
     * Logs the message on error level
     * @param text Error text
     */
    public static void error(String text) {
        LOGGER.log(Level.ERROR, text);
        LOGGER.log(Level.INFO, "Report this error on our official issue tracker: https://github.com/RedGrapefruit09/ImprovedFood/issues");
    }

    /**
     * Logs the message on fatal level
     * @param text Fatal error text
     */
    public static void fatal(String text) {
        LOGGER.log(Level.FATAL, text);
        LOGGER.log(Level.FATAL, "Report this fatal error on our official issue tracker: https://github.com/RedGrapefruit09/ImprovedFood/issues");
    }
}
