package com.redgrapefruit.improvedfood;

import com.redgrapefruit.improvedfood.registry.BlockRegistry;
import com.redgrapefruit.improvedfood.registry.ItemGroupRegistry;
import com.redgrapefruit.improvedfood.registry.ItemRegistry;
import com.redgrapefruit.improvedfood.registry.PatchRegistry;
import com.redgrapefruit.redcore.util.Logging;
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
        ItemGroupRegistry.run();
        ItemRegistry.run();
        PatchRegistry.run();
        BlockRegistry.run();

        Logging.info("ImprovedFood loaded on common side");
    }
}
