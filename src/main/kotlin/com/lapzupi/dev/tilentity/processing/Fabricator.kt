package com.lapzupi.dev.tilentity.processing

import com.lapzupi.dev.registry.GUIMaterials
import de.studiocode.invui.gui.GUI
import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.material.ItemNovaMaterial
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity
import xyz.xenondevs.nova.ui.config.side.SideConfigGUI
import xyz.xenondevs.nova.ui.item.ProgressItem

//Turns empty blueprint into filled blueprints
//Can use any recipe, vanilla recipes, nova recipes etc
class Fabricator(blockState: NovaTileEntityState) : NetworkedTileEntity(blockState) {
    
    override val gui: Lazy<TileEntityGUI>?
        get() = TODO("Not yet implemented")
    
    inner class FabricatorGUI : TileEntityGUI() {
        private val mainProgress = ProgressItem(GUIMaterials.ARROW_PROGRESS as ItemNovaMaterial, 16)
        
        //our input is our output.. the "empty" turns into a filled version
        
        private val sideConfigGUI = SideConfigGUI(
            this@Fabricator, listOf(
            itemHolder.getNetworkedInventory(inputInv) to "inventory.nova.input",
            itemHolder.getNetworkedInventory(outputInv) to "inventory.nova.output",
        ), ::openWindow
        )
        override val gui: GUI
            get() = TODO("Not yet implemented")
    }
}