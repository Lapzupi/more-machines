package com.lapzupi.dev.tilentity.processing

import com.lapzupi.dev.recipe.recycler.RecyclerRecipe
import com.lapzupi.dev.registry.Blocks.RECYCLER
import com.lapzupi.dev.registry.GUIMaterials
import com.lapzupi.dev.registry.RecipeTypes
import de.studiocode.invui.gui.GUI
import de.studiocode.invui.gui.SlotElement
import de.studiocode.invui.gui.builder.GUIBuilder
import de.studiocode.invui.gui.builder.guitype.GUIType
import de.studiocode.invui.virtualinventory.event.ItemUpdateEvent
import org.bukkit.NamespacedKey
import xyz.xenondevs.nova.data.config.NovaConfig
import xyz.xenondevs.nova.data.config.configReloadable
import xyz.xenondevs.nova.data.recipe.RecipeManager
import xyz.xenondevs.nova.data.world.block.state.NovaTileEntityState
import xyz.xenondevs.nova.material.ItemNovaMaterial
import xyz.xenondevs.nova.tileentity.NetworkedTileEntity
import xyz.xenondevs.nova.tileentity.network.NetworkConnectionType
import xyz.xenondevs.nova.tileentity.network.energy.holder.ConsumerEnergyHolder
import xyz.xenondevs.nova.tileentity.network.item.holder.NovaItemHolder
import xyz.xenondevs.nova.tileentity.upgrade.Upgradable
import xyz.xenondevs.nova.tileentity.upgrade.UpgradeType
import xyz.xenondevs.nova.ui.EnergyBar
import xyz.xenondevs.nova.ui.OpenUpgradesItem
import xyz.xenondevs.nova.ui.config.side.OpenSideConfigItem
import xyz.xenondevs.nova.ui.config.side.SideConfigGUI
import xyz.xenondevs.nova.ui.item.ProgressItem
import xyz.xenondevs.nova.util.BlockSide
import xyz.xenondevs.nova.util.advance
import xyz.xenondevs.nova.util.particle
import xyz.xenondevs.particle.ParticleEffect
import kotlin.math.max

private val MAX_ENERGY = configReloadable { NovaConfig[RECYCLER].getLong("capacity") }
private val ENERGY_PER_TICK = configReloadable { NovaConfig[RECYCLER].getLong("energy_per_tick") }
private val RECYCLER_SPEED by configReloadable { NovaConfig[RECYCLER].getInt("speed")}

class Recycler (blockState: NovaTileEntityState) : NetworkedTileEntity(blockState), Upgradable {

    override val gui = lazy { RecyclerGUI() }

    private val inputInv = getInventory("input", 1, ::handleInputUpdate)
    private val outputInv = getInventory("output", 2, ::handleOutputUpdate)

    override val upgradeHolder = getUpgradeHolder(UpgradeType.SPEED, UpgradeType.EFFICIENCY, UpgradeType.ENERGY)
    override val energyHolder = ConsumerEnergyHolder(this, MAX_ENERGY, ENERGY_PER_TICK, null, upgradeHolder) { createSideConfig(
        NetworkConnectionType.INSERT, BlockSide.FRONT) }

    override val itemHolder = NovaItemHolder(
        this,
        inputInv to NetworkConnectionType.BUFFER,
        outputInv to NetworkConnectionType.EXTRACT
    ) { createSideConfig(NetworkConnectionType.INSERT, BlockSide.FRONT) }

    private var timeLeft = retrieveData("recyclerTime") { 0 }
    private var recyclerSpeed = 0
    private var currentRecipe: RecyclerRecipe? =
        retrieveDataOrNull<NamespacedKey>("currentRecipe")?.let { RecipeManager.getRecipe(RecipeTypes.RECYCLER, it) }
    private val particleTask = createParticleTask(listOf(
        particle(ParticleEffect.SMOKE_NORMAL) {
            location(centerLocation.advance(getFace(BlockSide.FRONT), 0.6).apply { y += 0.8 })
            offset(0.05, 0.2, 0.05)
            speed(0f)
        }
    ), 6)

    init {
        reload()
        if (currentRecipe == null) timeLeft = 0
    }

    override fun reload() {
        super.reload()
        recyclerSpeed = (RECYCLER_SPEED * upgradeHolder.getValue(UpgradeType.SPEED)).toInt()
    }

    override fun handleTick() {
        if (energyHolder.energy >= energyHolder.energyConsumption) {
            if (timeLeft == 0) {
                takeItem()

                if (particleTask.isRunning()) particleTask.stop()
            } else {
                timeLeft = max(timeLeft - recyclerSpeed, 0)
                energyHolder.energy -= energyHolder.energyConsumption

                if (!particleTask.isRunning()) particleTask.start()

                if (timeLeft == 0) {
                    outputInv.addItem(SELF_UPDATE_REASON, currentRecipe!!.result)
                    currentRecipe = null
                }

                if (gui.isInitialized()) gui.value.updateProgress()
            }

        } else if (particleTask.isRunning()) particleTask.stop()
    }

    private fun takeItem() {
        val inputItem = inputInv.getItemStack(0)
        if (inputItem != null) {
            val recipe = RecipeManager.getConversionRecipeFor(RecipeTypes.RECYCLER, inputItem)!!
            val result = recipe.result
            if (outputInv.canHold(result)) {
                inputInv.addItemAmount(SELF_UPDATE_REASON, 0, -1)
                timeLeft = recipe.time
                currentRecipe = recipe
            }
        }
    }

    inner class RecyclerGUI: TileEntityGUI() {
        private val mainProgress = ProgressItem(GUIMaterials.ARROW_PROGRESS as ItemNovaMaterial, 16)

        private val sideConfigGUI = SideConfigGUI(
            this@Recycler,
            listOf(
                itemHolder.getNetworkedInventory(inputInv) to "inventory.nova.input",
                itemHolder.getNetworkedInventory(outputInv) to "inventory.nova.output"
            ),
            ::openWindow
        )

        override val gui: GUI = GUIBuilder(GUIType.NORMAL)
            .setStructure(
                "1 - - - - - - - 2",
                "| s u # # # # e |",
                "| i # , # o a e |",
                "| # # # # # # e |",
                "3 - - - - - - - 4")
            .addIngredient('i', SlotElement.VISlotElement(inputInv, 0))
            .addIngredient('o', SlotElement.VISlotElement(outputInv, 0))
            .addIngredient('a', SlotElement.VISlotElement(outputInv, 1))
            .addIngredient(',', mainProgress)
            .addIngredient('s', OpenSideConfigItem(sideConfigGUI))
            .addIngredient('u', OpenUpgradesItem(upgradeHolder))
            .addIngredient('e', EnergyBar(3, energyHolder))
            .build()

        init {
            updateProgress()
        }

        fun updateProgress() {
            val recipeTime = currentRecipe?.time ?: 0
            val percentage = if (timeLeft == 0) 0.0 else (recipeTime - timeLeft).toDouble() / recipeTime.toDouble()
            mainProgress.percentage = percentage
        }
    }

    override fun saveData() {
        super.saveData()
        storeData("recyclerTime", timeLeft)
        storeData("currentRecipe", currentRecipe?.key)
    }
    private fun handleInputUpdate(event: ItemUpdateEvent) {
        event.isCancelled = event.newItemStack != null && RecipeManager.getConversionRecipeFor(RecipeTypes.RECYCLER, event.newItemStack) == null
    }

    private fun handleOutputUpdate(event: ItemUpdateEvent) {
        event.isCancelled = !event.isRemove && event.updateReason != SELF_UPDATE_REASON
    }
}