package com.lapzupi.dev.registry

import com.lapzupi.dev.MoreMachinesAddon
import com.lapzupi.dev.tilentity.processing.AutoCrafter
import com.lapzupi.dev.tilentity.processing.BlueprintCrafter
import com.lapzupi.dev.tilentity.processing.ElectricComposter
import com.lapzupi.dev.tilentity.processing.Recycler
import org.bukkit.Material
import xyz.xenondevs.nova.data.world.block.property.Directional
import xyz.xenondevs.nova.item.tool.ToolCategory
import xyz.xenondevs.nova.item.tool.ToolLevel
import xyz.xenondevs.nova.material.BlockOptions
import xyz.xenondevs.nova.material.NovaMaterialRegistry.registerTileEntity
import xyz.xenondevs.nova.world.block.sound.SoundGroup


object Blocks {
    private val STONE = BlockOptions(3.0, listOf(ToolCategory.PICKAXE), ToolLevel.STONE, true, SoundGroup.STONE, Material.NETHERITE_BLOCK, true)

    val BLUEPRINT_CRAFTER = registerTileEntity(MoreMachinesAddon, "blueprint_crafter", STONE, ::BlueprintCrafter, properties = listOf(Directional.NORMAL))
    val AUTO_CRAFTER = registerTileEntity(MoreMachinesAddon, "auto_crafter", STONE, ::AutoCrafter, properties = listOf(Directional.NORMAL))
    val ELECTRIC_COMPOSTER = registerTileEntity(MoreMachinesAddon, "electric_composter", STONE, ::ElectricComposter, properties = listOf(Directional.NORMAL))
    val RECYCLER = registerTileEntity(MoreMachinesAddon, "recycler", STONE, ::Recycler, properties = listOf(Directional.NORMAL))


    fun init() = Unit

}