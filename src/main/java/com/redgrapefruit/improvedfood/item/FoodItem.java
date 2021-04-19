package com.redgrapefruit.improvedfood.item;

import com.redgrapefruit.improvedfood.core.*;
import com.redgrapefruit.improvedfood.registry.ItemGroupRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

/**
 * The native implementation of food logic.<br>
 * Used for new types of food introduced by the mod and as a base for rotten, overdue, salted food variants
 */
public class FoodItem extends Item {
    private final FoodConfig config;
    private final FoodProfile profile;

    /**
     * Internal constructor allowing to use different {@link ItemGroup}'s and {@link FoodComponent}'s (used by food variants)
     * @param config Food config
     * @param group Item group from {@link ItemGroupRegistry}
     * @param componentSupplier A {@link FoodComponent} supplier because a supplier can be constructed using a lambda method which is useful in this case
     */
    protected FoodItem(FoodConfig config, ItemGroup group, Supplier<FoodComponent> componentSupplier) {
        super(new Item.Settings().group(group).food(componentSupplier.get()));

        this.config = config;
        this.profile = new FoodProfile(config); // TODO: Replace with deserialized profile instead of creating a new profile every launch of the game
    }

    public FoodItem(FoodConfig config) {
        this(config, ItemGroupRegistry.FRESH_FOOD, () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();

            // Hunger property
            builder.hunger(config.getCategory().getBaseHunger() + config.getHunger());
            // Meat property
            if (config.getCategory() == FoodCategory.MEAT) {
                builder.meat();
            }
            // Snack property (is a snack if hunger is less than 3)
            if (config.getCategory().getBaseHunger() + config.getHunger() < 3) {
                builder.snack();
            }
            // Saturation modifier property
            builder.saturationModifier(config.getCategory().getBaseSaturation() + config.getSaturationModifier());
            // Effects
            for (FoodEffectConfig effectConfig : config.getEffects()) {
                builder.statusEffect(
                        new StatusEffectInstance(effectConfig.getStatusEffect(), effectConfig.getDuration(), effectConfig.getAmplifier()),
                        effectConfig.isAlwaysApplied() ? 1.0f : effectConfig.getChance()
                );
            }

            return builder.build();
        });
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        FoodSystem.appendTooltip(tooltip, config, profile);
    }
}
