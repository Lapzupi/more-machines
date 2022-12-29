package com.lapzupi.dev

import com.lapzupi.dev.registry.Blocks
import com.lapzupi.dev.registry.RecipeTypes
import xyz.xenondevs.nova.addon.Addon

object MoreMachinesAddon : Addon() {

    override fun init() {
        Blocks.init()
        RecipeTypes.init()
    }
    
    override fun onEnable() = Unit
    
    override fun onDisable() = Unit
    
}