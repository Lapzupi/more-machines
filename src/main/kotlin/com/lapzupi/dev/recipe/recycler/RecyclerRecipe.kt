package com.lapzupi.dev.recipe.recycler

import com.lapzupi.dev.registry.RecipeTypes
import net.minecraft.resources.ResourceLocation
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import xyz.xenondevs.nova.data.recipe.ConversionNovaRecipe

class RecyclerRecipe(key: ResourceLocation,
                     input: RecipeChoice,
                     result: ItemStack,
                     time: Int,
) : ConversionNovaRecipe(key, input, result, time) {
    override val type = RecipeTypes.RECYCLER
}