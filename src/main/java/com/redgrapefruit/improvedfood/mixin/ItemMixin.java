package com.redgrapefruit.improvedfood.mixin;

import com.redgrapefruit.improvedfood.core.FoodConfig;
import com.redgrapefruit.improvedfood.core.FoodProfile;
import com.redgrapefruit.improvedfood.core.FoodSystem;
import com.redgrapefruit.improvedfood.util.ItemMixinAccess;
import net.minecraft.client.item.TooltipContext;
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
    @Unique private FoodConfig config = null;
    @Unique private FoodProfile profile = null;
    @Unique private boolean isActivated = false;

    @Inject(method = "appendTooltip", at = @At("TAIL"))
    private void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context, CallbackInfo info) {
        if (!isActivated) return;

        FoodSystem.appendTooltip(tooltip, config, profile, "Fresh");
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
}
