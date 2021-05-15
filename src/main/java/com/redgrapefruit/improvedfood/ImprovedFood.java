package com.redgrapefruit.improvedfood;

import com.redgrapefruit.improvedfood.registry.*;
import com.redgrapefruit.redcore.util.Logging;
import com.redgrapefruit.redcore.util.ResourceGenerator;
import net.fabricmc.api.ModInitializer;

import java.util.Random;

/**
 * A common initializer registering client + server content
 */
public class ImprovedFood implements ModInitializer {
    /**
     * Mod identifier for resources
     */
    public static final String MOD_ID = "improvedfood";

    /**
     * Random instance
     */
    public static final Random RANDOM = new Random();

    @Override
    public void onInitialize() {
        // Setup generator
        ResourceGenerator.setMod(MOD_ID);
        // Run registries
        ItemGroupRegistry.run();
        ItemRegistry.run();
        PatchRegistry.run();
        BlockRegistry.run();
        FeatureRegistry.run();
        BiomeModificationRegistry.run();
        ResourcePackRegistry.run();

        Logging.info("ImprovedFood loaded on common side");
    }
}
