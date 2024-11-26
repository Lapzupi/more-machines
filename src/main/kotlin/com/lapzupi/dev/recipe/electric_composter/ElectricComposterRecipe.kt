package com.lapzupi.dev.recipe.electric_composter

import com.lapzupi.dev.registry.RecipeTypes
import net.minecraft.resources.ResourceLocation
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import xyz.xenondevs.nova.data.recipe.ConversionNovaRecipe

/**
 *
 * @author sarhatabaot
 */
class ElectricComposterRecipe (id: ResourceLocation,
                               input: RecipeChoice,
                               result: ItemStack,
                               time: Int,
) : ConversionNovaRecipe(id, input, result, time) {
    override val type = RecipeTypes.ELECTRIC_COMPOSTER
}