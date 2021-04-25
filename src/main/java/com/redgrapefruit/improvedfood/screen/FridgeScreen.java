package com.redgrapefruit.improvedfood.screen;

import com.redgrapefruit.improvedfood.ImprovedFood;
import com.redgrapefruit.redcore.container.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * A fridge screen implemented using RedCore.Container library
 */
public class FridgeScreen extends ContainerScreen {
    public FridgeScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected Identifier getTexture() {
        return new Identifier(ImprovedFood.MOD_ID, "textures/gui/fridge.png");
    }

    @Override
    protected void onRender() {

    }
}
