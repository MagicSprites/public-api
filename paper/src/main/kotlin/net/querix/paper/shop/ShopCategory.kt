package net.querix.paper.shop

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

interface ShopCategory {
    fun items(): Collection<ShopElement>
    fun addElement(element: ShopElement)
    fun categoryId(): String
    fun typeId(): String
    fun item(): ItemStack
}