package com.redgrapefruit.improvedfood;

import com.redgrapefruit.improvedfood.registry.GuiRegistry;
import com.redgrapefruit.redcore.util.Logging;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * A client initializer registering client-only content
 */
@Environment(EnvType.CLIENT)
public class ImprovedFoodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GuiRegistry.runClient();

        Logging.info("ImprovedFood loaded on client side");
    }
}
