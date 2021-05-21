package com.redgrapefruit.improvedfood.common.util;

import com.redgrapefruit.improvedfood.common.core.FoodConfig;
import com.redgrapefruit.improvedfood.common.core.FoodProfile;
import com.redgrapefruit.improvedfood.common.item.OverdueFoodItem;
import com.redgrapefruit.improvedfood.common.item.RottenFoodItem;
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

    boolean isActivated();
}
