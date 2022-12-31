package com.lapzupi.dev

import com.lapzupi.dev.registry.Blocks
import com.lapzupi.dev.registry.Items
import com.lapzupi.dev.registry.RecipeTypes
import xyz.xenondevs.nova.addon.Addon
import java.util.logging.Logger

lateinit var LOGGER: Logger
object MoreMachinesAddon : Addon() {

    override fun init() {
        LOGGER = logger

        Blocks.init()
        Items.init()
        RecipeTypes.init()
    }
    
    override fun onEnable() = Unit
    
    override fun onDisable() = Unit
    
}