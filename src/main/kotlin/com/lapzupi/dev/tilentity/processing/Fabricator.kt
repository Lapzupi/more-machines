package com.lapzupi.dev.tilentity.processing

import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity

//Turns empty blueprint into filled blueprints
//Can use any recipe, vanilla recipes, nova recipes etc
class Fabricator(blockState: NovaTileEntityState) : NetworkedTileEntity(blockState) {

    
//    inner class FabricatorGUI : TileEntityGUI() {
//        private val mainProgress = ProgressItem(GUIMaterials.ARROW_PROGRESS as NovaItem, 16)
//
//        //our input is our output.. the "empty" turns into a filled version
//
//        private val sideConfigGUI = SideConfigGUI(
//            this@Fabricator, listOf(
//            itemHolder.getNetworkedInventory(inputInv) to "inventory.nova.input",
//            itemHolder.getNetworkedInventory(outputInv) to "inventory.nova.output",
//        ), ::openWindow
//        )
//    }
}