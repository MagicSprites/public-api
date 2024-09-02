package net.querix.paper.game.pack

import org.bukkit.entity.Player
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack

class InventoryPack {
    private val itemsMap: MutableMap<Int, ItemStack> = mutableMapOf()
    private val equipmentMap: MutableMap<EquipmentSlot, ItemStack> = mutableMapOf()

    private val items: MutableList<ItemStack> = mutableListOf()

    fun addItem(slot: Int, itemStack: ItemStack): InventoryPack {
        itemsMap[slot] = itemStack
        return this
    }

    fun addItem(itemStack: ItemStack): InventoryPack {
        items.add(itemStack)
        return this
    }

    fun addItem(slot: EquipmentSlot, itemStack: ItemStack): InventoryPack {
        equipmentMap[slot] = itemStack
        return this
    }

    fun apply(player: Player) {
        for (entry in itemsMap)
            player.inventory.setItem(entry.key, entry.value.clone())

        for (entry in equipmentMap)
            player.inventory.setItem(entry.key, entry.value.clone())

        for (item in items)
            player.inventory.addItem(item.clone())
    }
}