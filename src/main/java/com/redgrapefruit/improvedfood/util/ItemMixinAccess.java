package com.redgrapefruit.improvedfood.util;

import com.redgrapefruit.improvedfood.core.FoodConfig;
import com.redgrapefruit.improvedfood.core.FoodProfile;
import com.redgrapefruit.improvedfood.item.OverdueFoodItem;
import com.redgrapefruit.improvedfood.item.RottenFoodItem;
import com.redgrapefruit.improvedfood.item.SaltedFoodItem;
import com.redgrapefruit.improvedfood.mixin.ItemMixin;

/**
 * A duck interface for outer access to {@link ItemMixin}
 */
public interface ItemMixinAccess {
    /**
     * Informs the {@link ItemMixin} that it is activated and needs to fire events
     */
    void activate();

    // Setters
    void setProfile(FoodProfile profile);

    void setConfig(FoodConfig config);

    void setRottenVariant(RottenFoodItem rottenVariant);

    void setOverdueVariant(OverdueFoodItem overdueVariant);

    // Getters
    FoodProfile getFoodProfile();

    void setSaltedVariant(SaltedFoodItem saltedVariant);

    boolean isActivated();
}
