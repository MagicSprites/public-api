package net.querix.paper.protocol.hologram.line

import net.querix.paper.protocol.hologram.HologramLine
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.function.Consumer

interface ItemHologramLine : HologramLine {
    fun getItemStack(): ItemStack?
    fun setItemStack(item: ItemStack)
    fun setPickupAction(action: Consumer<Player>)
}