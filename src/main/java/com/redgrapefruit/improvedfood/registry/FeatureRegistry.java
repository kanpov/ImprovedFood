package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry for {@link Feature}s and {@link ConfiguredFeature}s
 */
public class FeatureRegistry {
    public static final ConfiguredFeature<?, ?> SALT_ORE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BlockRegistry.SALT_ORE.getDefaultState(),
                    6
            ))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    55
            )))
            .spreadHorizontally()
            .repeatRandomly(20);
    /**
     * A map of {@link ConfiguredFeature} {@link RegistryKey}s for use in {@link BiomeModification}s
     */
    private static final Map<String, RegistryKey<ConfiguredFeature<?, ?>>> keyMap = new HashMap<>();

    /**
     * Runs the registry code
     */
    public static void run() {
        register("salt_ore", SALT_ORE);
    }

    /**
     * Returns the {@link RegistryKey} of a {@link ConfiguredFeature} corresponding to given name
     *
     * @param name {@link ConfiguredFeature}'s name
     * @return Obtained {@link RegistryKey}
     */
    public static RegistryKey<ConfiguredFeature<?, ?>> getKey(String name) {
        return keyMap.get(name);
    }

    /**
     * Registers a {@link ConfiguredFeature} to Minecraft
     *
     * @param name    Feature name
     * @param feature {@link ConfiguredFeature}
     */
    private static void register(String name, ConfiguredFeature<?, ?> feature) {
        // Make a registry key
        RegistryKey<ConfiguredFeature<?, ?>> key = RegistryKey.of(
                Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(ImprovedFood.MOD_ID, name)
        );
        // Add it to the map
        keyMap.put(name, key);
        // Register the feature now
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), feature);
    }
}
