package com.redgrapefruit.improvedfood.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.apache.logging.log4j.Level;

import static com.redgrapefruit.improvedfood.ImprovedFood.LOGGER;

@Environment(EnvType.CLIENT)
public class ImprovedFoodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.log(Level.INFO, "ImprovedFood loaded on client side");
    }
}
