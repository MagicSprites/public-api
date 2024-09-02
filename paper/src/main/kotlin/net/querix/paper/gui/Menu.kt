package net.querix.paper.gui

import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Consumer

interface Menu {
    val inventory: Inventory
    val title: String
    val itemActionMap: MutableMap<Int, Consumer<Player>>

    fun setItem(slot: Int, item: ItemStack) {
        setItem(slot, item)
    }

    fun setItem(slot: Int, item: ItemStack, action: Player.() -> Unit) {
        setItem(slot, item, action)
    }

    fun setItem(slot: Int, item: ItemStack, action: Consumer<Player>)
    fun open(player: Player)
    fun open(vararg players: Player) {
        players.forEach { open(it) }
    }
}