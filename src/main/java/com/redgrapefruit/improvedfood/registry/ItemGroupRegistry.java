package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

/**
 * Registers item groups into Minecraft.
 */
public class ItemGroupRegistry {
    public static ItemGroup FRESH_FOOD;
    public static ItemGroup OVERDUE_FOOD;
    public static ItemGroup ROTTEN_FOOD;
    public static ItemGroup SEEDS;
    public static ItemGroup CROPS;
    public static ItemGroup STORAGE;
    public static ItemGroup DECORATIONS;

    public static void run() {
        // TODO: Replace placeholder icons
        FRESH_FOOD = register("fresh_food", Items.WHITE_BED);
        OVERDUE_FOOD = register("overdue_food", Items.GRAY_BED);
        ROTTEN_FOOD = register("rotten_food", Items.BLACK_BED);
        SEEDS = register("seeds", Items.ORANGE_BED);
        CROPS = register("crops", Items.YELLOW_BED);
        STORAGE = register("storage", Items.GREEN_BED);
        DECORATIONS = register("decorations", Items.BLUE_BED);
    }

    /**
     * Creates (registers?) a new item group (creative tab)
     * @param id Resource identifier
     * @param icon Icon item
     * @return Built item group
     */
    private static ItemGroup register(String id, Item icon) {
        return FabricItemGroupBuilder
                .create(new Identifier(ImprovedFood.MOD_ID, id))
                .icon(() -> new ItemStack(icon))
                .build();
    }
}
