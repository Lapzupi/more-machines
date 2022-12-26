package com.lapzupi.dev.tilentity.processing

import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity
import xyz.xenondevs.nova.tileentity.upgrade.Upgradable
import xyz.xenondevs.nova.tileentity.upgrade.UpgradeHolder


class AutoCrafter  (blockState: NovaTileEntityState) : NetworkedTileEntity(blockState), Upgradable {
    override val gui: Lazy<TileEntityGUI>?
        get() = TODO("Not yet implemented")
    override val upgradeHolder: UpgradeHolder
        get() = TODO("Not yet implemented")
}