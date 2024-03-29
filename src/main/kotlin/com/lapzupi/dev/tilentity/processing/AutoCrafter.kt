package com.lapzupi.dev.tilentity.processing

import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity
import xyz.xenondevs.nova.tileentity.upgrade.Upgradable
import xyz.xenondevs.nova.tileentity.upgrade.UpgradeHolder


class AutoCrafter  (blockState: NovaTileEntityState) : NetworkedTileEntity(blockState), Upgradable {
    private var timeLeft = retrieveData("autoCrafterTime") { 0 }
    override val upgradeHolder: UpgradeHolder
        get() = TODO("Not yet implemented")


    override fun saveData() {
        super.saveData()
        storeData("autoCrafterTime", timeLeft)
    }
}