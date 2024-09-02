package net.querix.paper.hotbar

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.function.Consumer

interface HotbarBuilder {
    fun apply(player: Player)
    fun remove(player: Player)
    fun addItem(slot: Int, item: ItemStack, action: Consumer<Player>): HotbarBuilder
    fun addItem(slot: Int, item: ItemStack): HotbarBuilder
    fun allowInteraction(allow: Boolean): HotbarBuilder
    fun build(): Hotbar
}