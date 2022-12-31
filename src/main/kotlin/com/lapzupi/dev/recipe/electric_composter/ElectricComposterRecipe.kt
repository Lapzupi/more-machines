package com.lapzupi.dev.recipe.electric_composter

import com.lapzupi.dev.registry.RecipeTypes
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import xyz.xenondevs.nova.data.recipe.ConversionNovaRecipe

/**
 *
 * @author sarhatabaot
 */
class ElectricComposterRecipe (key: NamespacedKey,
                               input: RecipeChoice,
                               result: ItemStack,
                               time: Int,
) : ConversionNovaRecipe(key, input, result, time) {
    override val type = RecipeTypes.ELECTRIC_COMPOSTER
}