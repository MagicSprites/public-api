package net.querix.paper.protocol.hologram

import org.bukkit.entity.Player
import java.util.function.Consumer

interface HologramLine {
    /**
     * set action, when player interact with line
     */
    fun setClickAction(action: Consumer<Player>)
}