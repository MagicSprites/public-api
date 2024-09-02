package net.querix.paper.shop

import org.bukkit.Material
import org.bukkit.entity.Player

interface ShopElement {
    val id: String
    val cost: Int
    val currency: ShopCurrency

    fun onSelect(player: Player)
    fun onApply(player: Player)
    fun onTakeOff(player: Player)

    fun material(): Material

    fun name(player: Player): String
    fun lore(player: Player): String

}