package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import com.redgrapefruit.improvedfood.block.FridgeBlock;
import com.redgrapefruit.improvedfood.block.NormalCropBlock;
import com.redgrapefruit.improvedfood.block.SaltOreBlock;
import com.redgrapefruit.improvedfood.block.entity.FridgeBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

/**
 * Registers mod blocks into Minecraft.
 */
public class BlockRegistry {
    public static final List<Block> CROP_BLOCKS = new ArrayList<>();

    // Crop blocks
    public static final NormalCropBlock TOMATO_CROP = new NormalCropBlock(ItemRegistry.TOMATO_SEEDS);
    public static final NormalCropBlock CUCUMBER_CROP = new NormalCropBlock(ItemRegistry.CUCUMBER_SEEDS);
    public static final NormalCropBlock KIWI_CROP = new NormalCropBlock(ItemRegistry.KIWI_SEEDS);
    public static final NormalCropBlock JACKFRUIT_CROP = new NormalCropBlock(ItemRegistry.JACKFRUIT_SEEDS);

    // Storage blocks
    public static final FridgeBlock FRIDGE = new FridgeBlock(FabricBlockSettings.copyOf(Blocks.CHEST));
    public static final BlockEntityType<FridgeBlockEntity> FRIDGE_BLOCK_ENTITY = BlockEntityType.Builder.create(FridgeBlockEntity::new, FRIDGE).build(null);

    // Ore blocks
    public static final SaltOreBlock SALT_ORE = new SaltOreBlock();

    /**
     * Runs the registry code
     */
    public static void run() {
        register("tomato_crop", TOMATO_CROP);
        register("cucumber_crop", CUCUMBER_CROP);
        register("kiwi_crop", KIWI_CROP);
        register("jackfruit_crop", JACKFRUIT_CROP);

        register("fridge", FRIDGE, FRIDGE_BLOCK_ENTITY, ItemGroupRegistry.STORAGE);

        register("salt_ore", SALT_ORE, ItemGroup.MISC);
    }

    /**
     * Registers a block without a {@link BlockItem}
     *
     * @param id    Resource identifier
     * @param block Block
     */
    private static void register(String id, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(ImprovedFood.MOD_ID, id), block);
        // Add to crop blocks list
        CROP_BLOCKS.add(block);
    }

    /**
     * Registers a block and a {@link BlockItem}
     *
     * @param id    Resource identifier
     * @param block Block
     * @param group {@link ItemGroup} for the {@link BlockItem}
     */
    private static void register(String id, Block block, ItemGroup group) {
        Registry.register(Registry.BLOCK, new Identifier(ImprovedFood.MOD_ID, id), block);
        Registry.register(Registry.ITEM, new Identifier(ImprovedFood.MOD_ID, id), new BlockItem(block, new Item.Settings().group(group)));
    }

    /**
     * Registers a block, a {@link BlockItem} and a {@link BlockEntity}
     *
     * @param id    Resource identifier
     * @param block Block
     * @param type  {@link BlockEntityType<T>}
     * @param group {@link ItemGroup} for the {@link BlockItem}
     * @param <T>   Block entity
     */
    private static <T extends BlockEntity> void register(String id, Block block, BlockEntityType<T> type, ItemGroup group) {
        register(id, block, group);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ImprovedFood.MOD_ID, id), type);
    }
}
