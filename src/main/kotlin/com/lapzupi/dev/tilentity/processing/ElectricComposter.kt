package com.lapzupi.dev.tilentity.processing

import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity
import xyz.xenondevs.nova.tileentity.upgrade.Upgradable
import xyz.xenondevs.nova.tileentity.upgrade.UpgradeHolder

// Should be able to get fertlizer out of this, only from organic items
class ElectricComposter (blockState: NovaTileEntityState) : NetworkedTileEntity(blockState), Upgradable {
    private var timeLeft = retrieveData("blueprintCrafterTime") { 0 }
    override val gui: Lazy<TileEntityGUI>?
        get() = TODO("Not yet implemented")

    override val upgradeHolder: UpgradeHolder
        get() = TODO("Not yet implemented")

    override fun saveData() {
        super.saveData()
        storeData("blueprintCrafterTime", timeLeft)
    }
}