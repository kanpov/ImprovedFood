package com.redgrapefruit.improvedfood;

import com.redgrapefruit.improvedfood.registry.BlockRegistry;
import com.redgrapefruit.improvedfood.registry.ItemGroupRegistry;
import com.redgrapefruit.improvedfood.registry.ItemRegistry;
import com.redgrapefruit.improvedfood.util.Logging;
import net.fabricmc.api.ModInitializer;

import java.util.Random;

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
        BlockRegistry.run();

        Logging.info("ImprovedFood loaded on common side");
    }
}
