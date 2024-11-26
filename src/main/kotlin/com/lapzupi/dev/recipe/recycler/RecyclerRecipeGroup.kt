package com.lapzupi.dev.recipe.recycler

import com.lapzupi.dev.registry.Blocks
import com.lapzupi.dev.registry.GUITextures
import com.lapzupi.dev.registry.Items
import xyz.xenondevs.nova.ui.menu.item.recipes.group.ConversionRecipeGroup

/**
 *
 * @author sarhatabaot
 */
object RecyclerRecipeGroup : ConversionRecipeGroup<RecyclerRecipe>() {
    override val icon = Items.RECYCLER.basicClientsideProvider
    override val priority = 4
    override val texture = GUITextures.RECIPE_RECYCLER
}