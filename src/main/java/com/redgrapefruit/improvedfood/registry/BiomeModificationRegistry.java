package com.redgrapefruit.improvedfood.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

/**
 * A registry for {@link BiomeModification}s
 */
public class BiomeModificationRegistry {
    /**
     * Runs the registry code
     */
    public static void run() {
        modify(FeatureRegistry.getKey("salt_ore"));
    }

    /**
     * Modifies the overworld with given ore's {@link RegistryKey}
     * @param key Ore's {@link RegistryKey}
     */
    private static void modify(RegistryKey<ConfiguredFeature<?, ?>> key) {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, key);
    }
}
