package com.lapzupi.dev

import com.lapzupi.dev.registry.RecipeTypes
import xyz.xenondevs.nova.addon.Addon
import java.util.logging.Logger

lateinit var LOGGER: Logger
object MoreMachinesAddon : Addon() {

    override fun init() {
        LOGGER = logger
        
        RecipeTypes.init()
    }
    
    override fun onEnable() = Unit
    
    override fun onDisable() = Unit
    
}