package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Registers mod blocks into Minecraft.
 */
public class BlockRegistry {
    /**
     * Runs the registry code
     */
    public static void run() {

    }

    /**
     * Registers a block and a block item
     * @param id Resource identifier
     * @param block Block
     * @param group Item group for the block item
     */
    private static void register(String id, Block block, ItemGroup group) {
        Registry.register(Registry.BLOCK, new Identifier(ImprovedFood.MOD_ID, id), block);
        Registry.register(Registry.ITEM, new Identifier(ImprovedFood.MOD_ID, id), new BlockItem(block, new Item.Settings().group(group)));
    }

    /**
     * Registers a block, a block item and a block entity
     * @param id Resource identifier
     * @param block Block
     * @param type {@link BlockEntityType<T>}
     * @param group Block item group
     * @param <T> Block entity
     */
    private static <T extends BlockEntity> void register(String id, Block block, BlockEntityType<T> type, ItemGroup group) {
        register(id, block, group);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ImprovedFood.MOD_ID, id), type);
    }
}
