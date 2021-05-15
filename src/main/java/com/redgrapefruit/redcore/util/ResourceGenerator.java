package com.redgrapefruit.redcore.util;

/**
 * Provides utilities for less boilerplate in AARP.<br><br>
 * A part of RedCore.Util library bundled with this mod.
 */
public class ResourceGenerator {
    // Change this variable before running your registries using setMod()
    private static String MOD_ID = "_UndefinedModId";

    /**
     * Sets the current mod id.
     * @param id Mod id
     */
    public static void setMod(String id) {
        MOD_ID = id;
    }
}
