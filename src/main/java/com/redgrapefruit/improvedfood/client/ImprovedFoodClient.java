package com.redgrapefruit.improvedfood.client;

import com.redgrapefruit.improvedfood.util.Logging;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ImprovedFoodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Logging.info("ImprovedFood loaded on client side");
    }
}
