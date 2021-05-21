package com.redgrapefruit.improvedfood.client.registry;

import com.redgrapefruit.improvedfood.common.ImprovedFood;
import com.redgrapefruit.improvedfood.client.screen.FridgeScreen;
import com.redgrapefruit.improvedfood.common.screen.handler.FridgeScreenHandler;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

/**
 * A registry for {@link Screen}s and {@link ScreenHandler}s
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
