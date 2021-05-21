package com.redgrapefruit.improvedfood.common.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

/**
 * An ore smelting into salt.
 */
public class SaltOreBlock extends Block {
    public SaltOreBlock() {
        super(FabricBlockSettings
                .of(Material.METAL)
                .hardness(2.5f)
                .requiresTool()
                .breakByTool(FabricToolTags.PICKAXES));
    }
}
