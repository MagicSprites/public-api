package net.querix.paper.shop

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

interface ShopCategory {
    fun items(): Collection<ShopElement>
    fun addElement(element: ShopElement)
    fun open(player: Player)
    fun id(): String
    fun item(): ItemStack
}