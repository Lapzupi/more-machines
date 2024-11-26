package com.lapzupi.dev.recipe.electric_composter

import com.lapzupi.dev.registry.GUITextures
import com.lapzupi.dev.registry.Items
import xyz.xenondevs.nova.ui.menu.item.recipes.group.ConversionRecipeGroup

/**
 *
 * @author sarhatabaot
 */
object ElectricComposterRecipeGroup : ConversionRecipeGroup<ElectricComposterRecipe>() {
    override val icon = Items.ELECTRICAL_COMPOSTER.basicClientsideProvider
    override val priority = 4
    override val texture = GUITextures.RECIPE_ELECTRIC_COMPOSTER
}