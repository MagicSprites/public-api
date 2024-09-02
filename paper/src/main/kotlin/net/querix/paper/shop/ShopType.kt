package net.querix.paper.shop

import org.bukkit.entity.Player

interface ShopType {
    val id: String

    fun registerCategory(category: ShopCategory)
    fun getCategory(id: String): ShopCategory?
    fun categories(): Collection<ShopCategory>
    fun open(player: Player)
    fun getSelected(player: Player): ShopElement?
    fun getSelectedId(player: Player): String?
    fun setSelected(player: Player, element: ShopElement)

    fun getStorageIds(player: Player): Collection<String>
    fun addElementToStorage(player: Player, element: ShopElement)
    fun hasElement(player: Player, element: ShopElement): Boolean
}