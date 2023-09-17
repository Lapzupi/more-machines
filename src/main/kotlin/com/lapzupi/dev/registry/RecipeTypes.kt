package com.lapzupi.dev.registry

import com.lapzupi.dev.MoreMachinesAddon
import com.lapzupi.dev.recipe.electric_composter.ElectricComposterRecipe
import com.lapzupi.dev.recipe.electric_composter.ElectricComposterRecipeDeserializer
import com.lapzupi.dev.recipe.electric_composter.ElectricComposterRecipeGroup
import com.lapzupi.dev.recipe.recycler.RecyclerRecipe
import com.lapzupi.dev.recipe.recycler.RecyclerRecipeDeserializer
import com.lapzupi.dev.recipe.recycler.RecyclerRecipeGroup
import xyz.xenondevs.nova.addon.registry.RecipeTypeRegistry


object RecipeTypes : RecipeTypeRegistry by MoreMachinesAddon.registry{
    val RECYCLER = registerRecipeType("recycler",  RecyclerRecipe::class, RecyclerRecipeGroup, RecyclerRecipeDeserializer)
    val ELECTRIC_COMPOSTER = registerRecipeType("electric_composter",  ElectricComposterRecipe::class, ElectricComposterRecipeGroup, ElectricComposterRecipeDeserializer)

    fun init() = Unit

}