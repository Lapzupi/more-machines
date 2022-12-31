package com.lapzupi.dev.recipe.electric_composter

import com.google.gson.JsonObject
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import xyz.xenondevs.nova.data.serialization.json.ConversionRecipeDeserializer

/**
 *
 * @author sarhatabaot
 */
object ElectricComposterRecipeDeserializer : ConversionRecipeDeserializer<ElectricComposterRecipe>(){
    override fun createRecipe(json: JsonObject, key: NamespacedKey, input: RecipeChoice, result: ItemStack, time: Int): ElectricComposterRecipe =
        ElectricComposterRecipe(key, input, result, time)

}