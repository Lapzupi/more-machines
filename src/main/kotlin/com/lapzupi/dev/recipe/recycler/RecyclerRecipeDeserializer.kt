package com.lapzupi.dev.recipe.recycler

import com.google.gson.JsonObject
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import xyz.xenondevs.nova.data.serialization.json.ConversionRecipeDeserializer

/**
 *
 * @author sarhatabaot
 */
object RecyclerRecipeDeserializer : ConversionRecipeDeserializer<RecyclerRecipe>(){
    override fun createRecipe(json: JsonObject, key: NamespacedKey, input: RecipeChoice, result: ItemStack, time: Int): RecyclerRecipe =
        RecyclerRecipe(key, input, result, time)

}