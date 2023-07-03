package com.lapzupi.dev.registry

import com.lapzupi.dev.MoreMachinesAddon
import com.lapzupi.dev.tilentity.processing.AutoCrafter
import com.lapzupi.dev.tilentity.processing.BlueprintCrafter
import com.lapzupi.dev.tilentity.processing.ElectricComposter
import com.lapzupi.dev.tilentity.processing.Recycler
import org.bukkit.Material
import xyz.xenondevs.nova.addon.registry.BlockRegistry
import xyz.xenondevs.nova.data.world.block.property.Directional
import xyz.xenondevs.nova.initialize.Init
import xyz.xenondevs.nova.item.options.BlockOptions
import xyz.xenondevs.nova.item.tool.VanillaToolCategories
import xyz.xenondevs.nova.item.tool.VanillaToolTiers
import xyz.xenondevs.nova.world.block.sound.SoundGroup


@Init
object Blocks: BlockRegistry by MoreMachinesAddon.registry {
    private val STONE = BlockOptions(
        3.0,
        listOf(VanillaToolCategories.PICKAXE),
        VanillaToolTiers.STONE,
        true,
        SoundGroup.STONE,
        Material.NETHERITE_BLOCK,
        true
    )

    val BLUEPRINT_CRAFTER = tileEntity("blueprint_crafter", ::BlueprintCrafter).blockOptions(STONE).properties(Directional.NORMAL).register()
    val AUTO_CRAFTER =  tileEntity("auto_crafter", ::AutoCrafter).blockOptions(STONE).properties(Directional.NORMAL).register()
    val ELECTRIC_COMPOSTER = tileEntity("electric_composter", ::ElectricComposter).blockOptions(STONE).properties(Directional.NORMAL).register()
    val RECYCLER = tileEntity("recycler", ::Recycler).blockOptions(STONE).properties(Directional.NORMAL).register()
}