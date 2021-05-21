package com.redgrapefruit.improvedfood.client.screen;

import com.redgrapefruit.improvedfood.common.ImprovedFood;
import com.redgrapefruit.improvedfood.api.ContainerScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * A fridge {@link Screen} implemented using RedCore.Container library
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
    protected void onRender(MatrixStack matrices) {

    }
}
