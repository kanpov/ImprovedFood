package com.redgrapefruit.improvedfood.core;

import com.redgrapefruit.improvedfood.util.Formatting;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import java.util.List;

/**
 * The core of this mod.<br>
 * Most important logic and events are here
 */
public class FoodSystem {
    /**
     * Appends the item's tooltip to display custom values in detail
     * @param tooltip Tooltip
     * @param config {@link FoodConfig}
     * @param profile {@link FoodProfile}
     * @param state Food state
     */
    public static void appendTooltip(List<Text> tooltip, FoodConfig config, FoodProfile profile, String state) {
        // TODO: Make labels language-independent using TranslatableText instead of LiteralText

        // State
        newLine(tooltip);
        tooltip.add(new LiteralText(Formatting.AQUA + "State: " + state));
        // Hunger
        newLine(tooltip);
        tooltip.add(new LiteralText(Formatting.GREEN + "Hunger: " + (config.getHunger() + config.getCategory().getBaseHunger())));
        // Saturation modifier
        tooltip.add(new LiteralText(Formatting.GOLD + "Saturation modifier: " + (config.getSaturationModifier() + config.getCategory().getBaseSaturation())));
        // Category and its description
        newLine(tooltip);
        tooltip.add(new LiteralText(Formatting.DARK_RED + "Category:"));
        tooltip.add(new LiteralText(Formatting.RED + config.getCategory().getDisplayName()));
        tooltip.add(new LiteralText(Formatting.YELLOW + config.getCategory().getDescription()));
        // Rot
        if (config.getCategory().canRot()) {
            newLine(tooltip);
            tooltip.add(new LiteralText(Formatting.DARK_GREEN + "Rot: " + profile.getRotProgress() + "/" + config.getRotState()));
        }
        // Overdue
        if (config.getCategory().canOverdue()) {
            newLine(tooltip);
            tooltip.add(new LiteralText(Formatting.DARK_PURPLE + "Overdue: " + profile.getOverdueProgress() + "/" + config.getOverdueState()));
        }
        // Fridge
        if (config.getCategory().canBePutInFridge()) {
            newLine(tooltip);
            tooltip.add(new LiteralText(Formatting.BLUE + "Is in a fridge: " + profile.isInFridge()));
            tooltip.add(new LiteralText(Formatting.DARK_BLUE + "Fridge efficiency: " + config.getFridgeEfficiency()));
        }
        // Salt
        if (config.getCategory().canBeSalted()) {
            newLine(tooltip);
            tooltip.add(new LiteralText(Formatting.WHITE + "Is salted: " + profile.isSalted()));
            tooltip.add(new LiteralText(Formatting.GRAY + "Salt efficiency: " + config.getSaltEfficiency()));
        }
    }

    private static void newLine(List<Text> tooltip) {
        tooltip.add(new LiteralText(""));
    }
}
