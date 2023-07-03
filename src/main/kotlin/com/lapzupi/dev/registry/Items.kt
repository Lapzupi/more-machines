package com.lapzupi.dev.registry

import com.lapzupi.dev.MoreMachinesAddon
import xyz.xenondevs.nova.material.NovaMaterialRegistry.registerDefaultItem

/**
 *
 * @author sarhatabaot
 */
object Items {

    //IRON PLATE + EMPTY MAP
    val EMPTY_BLUEPRINT = registerDefaultItem(MoreMachinesAddon, "empty_blueprint")
    val FILLED_BLUEPRINT = registerDefaultItem(MoreMachinesAddon, "filled_blueprint")

    //Fertilizer types, we should be able to create different fertilizer types through different items combinations..

    fun init() = Unit
}