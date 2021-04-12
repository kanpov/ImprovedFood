package com.redgrapefruit.improvedfood;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImprovedFood implements ModInitializer {
    // Statics
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "improvedfood";

    @Override
    public void onInitialize() {
        LOGGER.log(Level.INFO, "ImprovedFood loaded on common side");
    }
}
