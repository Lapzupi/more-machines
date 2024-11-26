package com.lapzupi.dev.recipe.electric_composter

import com.google.gson.JsonObject
import net.minecraft.resources.ResourceLocation
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import xyz.xenondevs.nova.data.serialization.json.serializer.ConversionRecipeDeserializer

/**
 *
 * @author sarhatabaot
 */
object ElectricComposterRecipeDeserializer : ConversionRecipeDeserializer<ElectricComposterRecipe>(){
    override fun createRecipe(json: JsonObject, id: ResourceLocation, input: RecipeChoice, result: ItemStack, time: Int): ElectricComposterRecipe =
        ElectricComposterRecipe(id, input, result, time)

}