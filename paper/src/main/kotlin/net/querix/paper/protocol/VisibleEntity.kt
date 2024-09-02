package net.querix.paper.protocol

import org.bukkit.entity.Player

/**
 * protocol (fake) entities will be extended this class
 */
interface VisibleEntity {
    fun getViewers(): Collection<Player>
    fun addViewer(player: Player)
    fun deleteViewer(player: Player)

    /**
     * spawn for every player on the server,
     * if player will join after it -> his also will see
     */
    fun spawn()

    /**
     * delete entity for everybody, no one will see it anymore
     */
    fun remove()
    fun isPublic(): Boolean
}