package net.querix.paper.util.actionitem

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

interface ActionItem {
    val id: String

    fun onRightClick(player: Player) {}
    fun onLeftClick(player: Player) {}
    fun onDrop(player: Player) {}
    fun onPickup(player: Player) {}

    fun itemStack(): ItemStack

    fun getBukkitItem(): ItemStack {
        checkRegistered()

        val item = itemStack().clone()
        val meta = item.itemMeta

        meta.persistentDataContainer.set(actionItemKey, PersistentDataType.STRING, id)
        item.itemMeta = meta

        return item
    }

    fun checkRegistered() {
        if (actionItemMap.containsKey(id))
            return

        actionItemMap[id] = this
    }
}