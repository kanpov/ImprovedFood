package com.redgrapefruit.improvedfood.mixin;

import com.redgrapefruit.improvedfood.core.FoodConfig;
import com.redgrapefruit.improvedfood.core.FoodProfile;
import com.redgrapefruit.improvedfood.core.FoodSystem;
import com.redgrapefruit.improvedfood.item.OverdueFoodItem;
import com.redgrapefruit.improvedfood.item.RottenFoodItem;
import com.redgrapefruit.improvedfood.registry.ConfigRegistry;
import com.redgrapefruit.improvedfood.registry.ItemRegistry;
import com.redgrapefruit.improvedfood.util.ItemMixinAccess;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * A mixin used as a "registry" for ItemMixin:<br>
 * <ol>
 *     <li>Injecting into static constructor in {@link Items} at TAIL</li>
 *     <li>Assigning food configs and profiles to vanilla food which are modified through {@link ItemMixin}</li>
 *     <li>{@link ItemMixin} will detect that <code>config</code> and <code>profile</code> variables aren't null</li>
 *     <li>{@link ItemMixin} will execute {@link FoodSystem} events</li>
 * </ol>
 */
@SuppressWarnings("UnresolvedMixinReference")
// Somehow MCDev doesn't recognize <clinit> keyword (used for injection to static constructor)
@Mixin(Items.class)
public class ItemsMixin {
    // Shadowed
    @Shadow
    @Final
    public static Item PORKCHOP;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void clinit(CallbackInfo info) {
        register(PORKCHOP, ConfigRegistry.PORKCHOP, ItemRegistry.PORKCHOP_ROTTEN);
    }

    /**
     * "Registers" the base properties of an item (no variants) as explained in the class javadoc above (from point number 2 to 4)
     *
     * @param item   Source item
     * @param config {@link FoodConfig}
     */
    private static ItemMixinAccess register(Item item, FoodConfig config) {
        // Cast the item to duck interface
        ItemMixinAccess access = (ItemMixinAccess) item;
        // Activate and assign fields
        access.activate();
        access.setConfig(config);
        access.setProfile(new FoodProfile(config)); // TODO: Replace with deserialized profile instead of creating a new profile every launch of the game

        return access;
    }

    // Register's with rotten and/or overdue variants

    private static void register(Item item, FoodConfig config, RottenFoodItem rottenVariant) {
        ItemMixinAccess access = register(item, config);
        access.setRottenVariant(rottenVariant);
    }

    private static void register(Item item, FoodConfig config, OverdueFoodItem overdueVariant) {
        ItemMixinAccess access = register(item, config);
        access.setOverdueVariant(overdueVariant);
    }

    private static void register(Item item, FoodConfig config, RottenFoodItem rottenVariant, OverdueFoodItem overdueVariant) {
        ItemMixinAccess access = register(item, config);
        access.setRottenVariant(rottenVariant);
        access.setOverdueVariant(overdueVariant);
    }
}
