package net.querix.paper.protocol.entity

import net.querix.paper.protocol.VisibleEntity
import net.querix.paper.protocol.entity.data.FakeEntityType
import org.bukkit.Location
import org.bukkit.entity.Player

interface FakeEntity : VisibleEntity {
    fun getId(): Int

    /**
     * teleport npc to specified [location]
     */
    fun setLocation(location: Location)
    /**
     * change npc skin
     */
    fun setSkin(texture: String,  signature: String)
    /**
     * change npc type
     */
    fun setType(type: FakeEntityType)
    /**
     * change head rotation of entity to [location]
     * for [player]
     */
    fun look(player: Player, location: Location)
}