package com.lapzupi.dev.tilentity.processing

import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity
import xyz.xenondevs.nova.tileentity.upgrade.Upgradable
import xyz.xenondevs.nova.tileentity.upgrade.UpgradeHolder


/* TODO
 takes any blueprint, and makes it
 we should be able to make blueprint via the fabricator. <- Didn't even make this yet.
 The fabricator, accepts an empty blueprint + a recipe, to make a blueprint version of that recipe.
 */
class BlueprintCrafter(blockState: NovaTileEntityState) : NetworkedTileEntity(blockState), Upgradable {
    private var timeLeft = retrieveData("blueprintCrafterTime") { 0 }
    override val gui: Lazy<TileEntityGUI>?
        get() = TODO("Not yet implemented")

    override val upgradeHolder: UpgradeHolder
        get() = TODO("Not yet implemented")

    override fun saveData() {
        super.saveData()
        storeData("autoCrafterTime", timeLeft)
    }
}