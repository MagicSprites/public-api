package net.querix.paper.hotbar.item

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.function.Consumer

data class HotbarItem (val item: ItemStack, val action: Consumer<Player>?) {
    fun use(player: Player) {
        action?.accept(player)
    }
}
