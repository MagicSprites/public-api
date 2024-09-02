package net.querix.paper.protocol.hologram

import org.bukkit.Location

interface HologramService {
    fun createSimpleHologram(location: Location): ModifiableHologram
    fun createLanguageHologram(location: Location, key: String): Hologram

}