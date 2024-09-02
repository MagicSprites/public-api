package net.querix.paper.hotbar

import net.querix.paper.hotbar.item.HotbarItem
import org.bukkit.entity.Player

interface Hotbar {
    fun apply(player: Player)
    fun remove(player: Player)
    fun allowInteraction(): Boolean
    fun itemMap(): Map<Int, HotbarItem>

    companion object {
        private val hotbars: MutableMap<Player, Hotbar> = mutableMapOf()

        fun registerHotbar(player: Player, hotbar: Hotbar) {
            for (i in hotbar.itemMap())
                player.inventory.setItem(i.key, i.value.item)

            hotbars[player] = hotbar
        }

        fun deleteHotbar(player: Player) {
            hotbars.remove(player)
            player.inventory.clear()
        }

        fun findHotbar(player: Player): Hotbar? {
            return hotbars[player]
        }
    }
}