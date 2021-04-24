package com.redgrapefruit.redcore.container;

import com.mojang.blaze3d.systems.RenderSystem;
import com.redgrapefruit.redcore.util.Logging;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * A container screen displaying the GUI.<br>
 * Can be overridden using built-in events to add custom GUI elements using vanilla HandledScreen features.<br><br>
 * A part of RedCore.Container library bundled with this mod.
 */
public abstract class ContainerScreen extends HandledScreen<ScreenHandler> {
    private final Identifier texture = getTexture();

    /**
     * Returns the screen GUI texture
     * @return GUI texture resource ID
     */
    protected abstract Identifier getTexture();

    /**
     * An event reserved for custom rendering and custom GUI elements
     */
    protected abstract void onRender();

    protected ContainerScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        // Reset color
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        // Bind texture
        if (client != null) {
            client.getTextureManager().bindTexture(texture);
        } else {
            Logging.error("Couldn't bind texture; MinecraftClient instance is null");
        }
        // Calculate center position
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        // Render the texture
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        // Render background and mouseover tooltip
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
        // Fire event
        onRender();
    }

    @Override
    protected void init() {
        super.init();
        // Center title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
}
