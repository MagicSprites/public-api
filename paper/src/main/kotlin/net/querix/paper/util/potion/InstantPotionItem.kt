package net.querix.paper.util.potion

import net.querix.paper.extension.setDisplayName
import net.querix.paper.extension.setTexture
import net.querix.paper.util.actionitem.ActionItem
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect

class InstantPotionItem(override val id: String, val name: String?, val color: PotionHeadColor, val effects: List<PotionEffect>) :
    ActionItem {

    override fun onRightClick(player: Player) {
        for (effect in effects)
            player.addPotionEffect(effect)
    }

    override fun itemStack(): ItemStack {
        return ItemStack(Material.PLAYER_HEAD)
            .setTexture(color.value)
            .setDisplayName(name)
    }
}