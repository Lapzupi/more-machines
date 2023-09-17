package com.lapzupi.dev.registry

import com.lapzupi.dev.MoreMachinesAddon
import xyz.xenondevs.nova.addon.registry.ItemRegistry
import xyz.xenondevs.nova.initialize.Init

/**
 *
 * @author sarhatabaot
 */
@Init
object Items: ItemRegistry by MoreMachinesAddon.registry {

    //IRON PLATE + EMPTY MAP
    val EMPTY_BLUEPRINT = registerItem("empty_blueprint")
    val FILLED_BLUEPRINT = registerItem("filled_blueprint")

    //Fertilizer types, we should be able to create different fertilizer types through different items combinations..
    
    val BLUEPRINT_CRAFTER = registerItem(Blocks.BLUEPRINT_CRAFTER)
    val AUTO_CRAFTER = registerItem(Blocks.AUTO_CRAFTER)
    val ELECTRICAL_COMPOSTER = registerItem(Blocks.ELECTRIC_COMPOSTER)
    val RECYCLER = registerItem(Blocks.RECYCLER)
}