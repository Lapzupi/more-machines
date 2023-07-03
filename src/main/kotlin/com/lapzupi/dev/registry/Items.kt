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
}