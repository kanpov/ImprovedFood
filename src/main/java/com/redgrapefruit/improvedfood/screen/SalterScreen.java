package com.redgrapefruit.improvedfood.screen;

import com.redgrapefruit.improvedfood.ImprovedFood;
import com.redgrapefruit.redcore.container.ContainerScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * A salter screen implemented using RedCore.Container
 */
public class SalterScreen extends ContainerScreen {
    public SalterScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected Identifier getTexture() {
        return new Identifier(ImprovedFood.MOD_ID, "textures/gui/salter.png");
    }

    @Override
    protected void onRender(MatrixStack matrices) {

    }
}
