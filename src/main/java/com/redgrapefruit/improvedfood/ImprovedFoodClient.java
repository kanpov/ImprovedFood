package com.redgrapefruit.improvedfood;

import com.redgrapefruit.redcore.util.Logging;
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
