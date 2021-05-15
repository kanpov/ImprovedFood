package com.redgrapefruit.improvedfood.registry;

import com.redgrapefruit.improvedfood.ImprovedFood;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;

/**
 * A registry for AARP resourcepacks
 */
public class ResourcePackRegistry {
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(ImprovedFood.MOD_ID + ":resources");

    /**
     * Registers the resourcepacks.<br>
     * <b>Must be run after ALL other registries</b>
     */
    public static void run() {
        RRPCallback.EVENT.register((listener) -> {
            listener.add(RESOURCE_PACK);
        });
    }
}
