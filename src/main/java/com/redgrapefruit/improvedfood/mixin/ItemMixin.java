package com.redgrapefruit.improvedfood.mixin;

import com.redgrapefruit.improvedfood.common.core.FoodSystem;
import com.redgrapefruit.improvedfood.common.core.FoodConfig;
import com.redgrapefruit.improvedfood.common.core.FoodProfile;
import com.redgrapefruit.improvedfood.common.core.FoodState;
import com.redgrapefruit.improvedfood.common.item.OverdueFoodItem;
import com.redgrapefruit.improvedfood.common.item.RottenFoodItem;
import com.redgrapefruit.improvedfood.common.util.ItemMixinAccess;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

/**
 * The mixin implementation of food logic.<br>
 * Used for expanding logic of vanilla food.
 */
@Mixin(Item.class)
public class ItemMixin implements ItemMixinAccess {
    @Unique
    private FoodConfig config = null;
    @Unique
    private FoodProfile profile = null;
    @Unique
    private boolean isActivated = false;
    @Unique
    private RottenFoodItem rottenVariant = null;
    @Unique
    private OverdueFoodItem overdueVariant = null;

    @Inject(method = "appendTooltip", at = @At("TAIL"))
    private void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context, CallbackInfo info) {
        if (!isActivated) return;

        FoodSystem.appendTooltip(tooltip, config, profile, FoodState.FRESH);
    }

    @Inject(method = "inventoryTick", at = @At("TAIL"))
    private void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo callbackInfo) {
        if (!isActivated || !(entity instanceof PlayerEntity)) return;

        FoodSystem.inventoryTick(config, profile, (PlayerEntity) entity, slot, world, rottenVariant, overdueVariant, false);
    }

    // Duck interface implementations
    @Override
    public void activate() {
        this.isActivated = true;
    }

    @Override
    public void setProfile(FoodProfile profile) {
        this.profile = profile;
    }

    @Override
    public void setConfig(FoodConfig config) {
        this.config = config;
    }

    @Override
    public void setRottenVariant(RottenFoodItem rottenVariant) {
        this.rottenVariant = rottenVariant;
    }

    @Override
    public void setOverdueVariant(OverdueFoodItem overdueVariant) {
        this.overdueVariant = overdueVariant;
    }

    @Override
    public FoodProfile getFoodProfile() {
        return profile;
    }

    @Override
    public boolean isActivated() {
        return isActivated;
    }
}
