package net.querix.paper.shop

import net.querix.paper.extension.user
import org.bukkit.entity.Player

enum class ShopCurrency(val color: String, val has: (Player, Int) -> Boolean, val take: (Player, Int) -> Unit) {
    COINS("§e", { player, value -> player.user().hasCoins(value) },
            { player, value -> player.user().takeCoins(value) }),
    CRYSTALS("§d", { player, value -> player.user().hasCrystals(value) },
        { player, value -> player.user().takeCrystals(value) })
}