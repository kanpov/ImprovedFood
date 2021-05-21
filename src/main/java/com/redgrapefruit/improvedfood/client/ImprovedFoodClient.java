package com.redgrapefruit.improvedfood.client;

import com.redgrapefruit.improvedfood.common.registry.BlockRegistry;
import com.redgrapefruit.improvedfood.client.registry.GuiRegistry;
import com.redgrapefruit.redcore.util.Logging;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

/**
 * A client initializer registering client-only content
 */
@Environment(EnvType.CLIENT)
public class ImprovedFoodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GuiRegistry.runClient();
        // Reset render layer for crops so they don't look black
        BlockRegistry.CROP_BLOCKS.forEach((block) -> {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        });

        Logging.info("ImprovedFood loaded on client side");
    }
}
