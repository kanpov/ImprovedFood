package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import com.redgrapefruit.improvedfood.screen.FridgeScreen;
import com.redgrapefruit.improvedfood.screen.handler.FridgeScreenHandler;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

/**
 * A registry for screens and screen handlers
 */
public class GuiRegistry {
    public static final ScreenHandlerType<FridgeScreenHandler> FRIDGE_SCREEN_HANDLER;

    // Common run
    static {
        FRIDGE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(ImprovedFood.MOD_ID, "fridge"), FridgeScreenHandler::new);
    }

    // Client run
    public static void runClient() {
        ScreenRegistry.register(FRIDGE_SCREEN_HANDLER, FridgeScreen::new);
    }
}
