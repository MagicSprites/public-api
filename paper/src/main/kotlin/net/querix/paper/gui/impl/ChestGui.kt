package net.querix.paper.gui.impl

import net.querix.paper.gui.Menu
import net.querix.paper.gui.guiMap
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Consumer

open class ChestGui(override val title: String, rows: Int) : Menu {
    override val inventory: Inventory = Bukkit.createInventory(null, rows * 9, title)
    override val itemActionMap: MutableMap<Int, Consumer<Player>> = mutableMapOf()

    override fun setItem(
        slot: Int,
        item: ItemStack,
        action: Consumer<Player>
    ) {
        inventory.setItem(slot, item)
        itemActionMap[slot] = action
    }

    override fun open(player: Player) {
        player.openInventory(inventory)
        guiMap[player] = this
    }
}