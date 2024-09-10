package net.querix.paper.shop

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

interface ShopCategory {
    fun items(): Collection<ShopElement>
    fun addElement(element: ShopElement)
    fun id(): String
    fun item(): ItemStack
}