package com.lapzupi.dev.registry

import xyz.xenondevs.nova.data.recipe.RecipeTypeRegistry.register
import com.lapzupi.dev.MoreMachinesAddon
import com.lapzupi.dev.recipe.electric_composter.ElectricComposterRecipe
import com.lapzupi.dev.recipe.electric_composter.ElectricComposterRecipeDeserializer
import com.lapzupi.dev.recipe.electric_composter.ElectricComposterRecipeGroup
import com.lapzupi.dev.recipe.recycler.RecyclerRecipe
import com.lapzupi.dev.recipe.recycler.RecyclerRecipeDeserializer
import com.lapzupi.dev.recipe.recycler.RecyclerRecipeGroup


object RecipeTypes {
    val RECYCLER = register(MoreMachinesAddon, "recycler",  RecyclerRecipe::class, RecyclerRecipeGroup, RecyclerRecipeDeserializer)
    val ELECTRIC_COMPOSTER = register(MoreMachinesAddon, "electric_composter",  ElectricComposterRecipe::class, ElectricComposterRecipeGroup, ElectricComposterRecipeDeserializer)

    fun init() = Unit

}