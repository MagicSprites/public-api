package net.querix.paper.protocol.hologram

import net.querix.paper.protocol.VisibleEntity
import org.bukkit.Location


interface Hologram : VisibleEntity {
    /**
     * change hologram [location]
     */
    fun teleport(location: Location)
}