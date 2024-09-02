package net.querix.paper.protocol.team

import net.querix.paper.protocol.VisibleEntity
import org.bukkit.entity.Player

interface FakeTeam : VisibleEntity {
    fun name(): String
    fun players(): List<String>
    fun addPlayer(player: Player)
    fun deletePlayer(player: Player)
    fun setPrefix(prefix: String)
    fun setSuffix(suffix: String)
    fun prefix(): String
    fun suffix(): String
    fun updateTeam()
}