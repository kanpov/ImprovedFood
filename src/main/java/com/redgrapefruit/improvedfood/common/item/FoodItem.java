package com.redgrapefruit.improvedfood.common.item;

import com.redgrapefruit.improvedfood.common.core.FoodSystem;
import com.redgrapefruit.improvedfood.common.core.FoodCategory;
import com.redgrapefruit.improvedfood.common.core.FoodConfig;
import com.redgrapefruit.improvedfood.common.core.FoodEffectConfig;
import com.redgrapefruit.improvedfood.common.core.FoodProfile;
import com.redgrapefruit.improvedfood.common.core.FoodState;
import com.redgrapefruit.improvedfood.common.registry.ItemGroupRegistry;
import com.redgrapefruit.improvedfood.common.util.IntRange;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
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
     * A custom state for managing tooltips. Overridden by variants
     */
    private FoodState state;
    /**
     * Will the food item override effects. Overridden by variants
     */
    private boolean overrideEffects = false;
    /**
     * Is the food salted
     */
    private boolean isSalted = false;

    // Variants
    private RottenFoodItem rottenVariant;
    private OverdueFoodItem overdueVariant;

    /**
     * Internal constructor allowing to use different {@link ItemGroup}'s and {@link FoodComponent}'s (used by food variants)
     *
     * @param config            {@link FoodConfig}
     * @param group             {@link ItemGroup} from {@link ItemGroupRegistry}
     * @param componentSupplier A {@link FoodComponent} supplier because a supplier can be constructed using a lambda method which is useful in this case
     */
    protected FoodItem(FoodConfig config, ItemGroup group, Supplier<FoodComponent> componentSupplier) {
        super(new Item.Settings().group(group).food(componentSupplier.get()));

        this.config = config;
        this.profile = new FoodProfile(config); // TODO: Replace with deserialized profile instead of creating a new profile every launch of the game
        this.state = FoodState.FRESH;
    }

    /**
     * Public constructor creating a standard non-variant food item
     *
     * @param config {@link FoodConfig}
     */
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
                // orElseGet will be removed in 0.2f along with deprecated FoodEffectConfig#duration and FoodEffectConfig#amplifier and Optional usage

                int duration = effectConfig.getAmplifierRange()
                        .map(IntRange::pick)
                        .orElseGet(effectConfig::getAmplifier);

                int amplifier = effectConfig.getDurationRange()
                        .map(IntRange::pick)
                        .orElseGet(effectConfig::getDuration);

                builder.statusEffect(
                        new StatusEffectInstance(
                                effectConfig.getStatusEffect(),
                                effectConfig.isPermanent() ? Integer.MAX_VALUE : duration,
                                amplifier
                        ),
                        effectConfig.isAlwaysApplied() ? 1.0f : effectConfig.getChance()
                );
            }

            return builder.build();
        });
    }

    /**
     * A builder method setting a rotten variant of this {@link FoodItem}
     *
     * @param rottenVariant Rotten variant
     * @return Self
     */
    public FoodItem setRottenVariant(RottenFoodItem rottenVariant) {
        this.rottenVariant = rottenVariant;
        return this;
    }

    /**
     * A builder method setting an overdue variant of this {@link FoodItem}
     *
     * @param overdueVariant Overdue variant
     * @return Self
     */
    public FoodItem setOverdueVariant(OverdueFoodItem overdueVariant) {
        this.overdueVariant = overdueVariant;
        return this;
    }

    /**
     * Sets the custom {@link FoodState} of this food item
     *
     * @param state {@link FoodState}
     */
    protected void setState(FoodState state) {
        this.state = state;
    }

    /**
     * Enables effect overrides
     */
    public void overrideEffects() {
        this.overrideEffects = true;
    }

    /**
     * Marks the food item as salted
     */
    public void salted() {
        this.isSalted = true;
    }

    public FoodProfile getProfile() {
        return profile;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        FoodSystem.appendTooltip(tooltip, config, profile, state);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (!(entity instanceof PlayerEntity) || overrideEffects) return;

        FoodSystem.inventoryTick(config, profile, (PlayerEntity) entity, slot, world, rottenVariant, overdueVariant, isSalted);
    }
}
