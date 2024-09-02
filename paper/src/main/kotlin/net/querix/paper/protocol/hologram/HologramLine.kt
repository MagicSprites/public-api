package net.querix.paper.protocol.hologram

import org.bukkit.entity.Player

interface HologramLine {
    /**
     * set action, when player interact with line
     */
    fun setClickAction(action: (Player) -> Unit)
}