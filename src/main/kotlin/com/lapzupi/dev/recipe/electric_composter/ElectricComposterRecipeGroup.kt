package com.lapzupi.dev.recipe.electric_composter

import com.lapzupi.dev.registry.Blocks
import com.lapzupi.dev.registry.GUITextures
import xyz.xenondevs.nova.ui.menu.item.recipes.group.ConversionRecipeGroup

/**
 *
 * @author sarhatabaot
 */
object ElectricComposterRecipeGroup : ConversionRecipeGroup() {
    override val icon = Blocks.ELECTRIC_COMPOSTER.basicClientsideProvider
    override val priority = 4
    override val texture = GUITextures.RECIPE_ELECTRIC_COMPOSTER
}