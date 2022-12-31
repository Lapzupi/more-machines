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

    fun init() = Unit
}