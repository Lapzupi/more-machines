package com.lapzupi.dev.recipe.recycler

import com.google.gson.JsonObject
import net.minecraft.resources.ResourceLocation
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import xyz.xenondevs.nova.data.serialization.json.serializer.ConversionRecipeDeserializer

/**
 *
 * @author sarhatabaot
 */
object RecyclerRecipeDeserializer : ConversionRecipeDeserializer<RecyclerRecipe>(){

    override fun createRecipe(json: JsonObject, id: ResourceLocation, input: RecipeChoice, result: ItemStack, time: Int): RecyclerRecipe =
        RecyclerRecipe(id, input, result, time)
    
}