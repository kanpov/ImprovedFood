package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers mod items into Minecraft.
 */
public class ItemRegistry {
    /**
     * Runs the registry code
     */
    public static void run() {

    }

    /**
     * Registers an item to Minecraft.
     * @param id Resource identifier
     * @param item Item
     */
    private static void register(String id, Item item) {
        Registry.register(Registry.ITEM, new Identifier(ImprovedFood.MOD_ID, id), item);
    }
}
