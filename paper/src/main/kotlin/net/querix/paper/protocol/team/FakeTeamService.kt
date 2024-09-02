package net.querix.paper.protocol.team

import org.bukkit.entity.Player

interface FakeTeamService {
    fun createTeam(priority: Int, name: String): FakeTeam

    // you do not need to be called, it calls automaticly by FakeTeam#remove
    fun deleteTeam(team: FakeTeam)
    // you do not need to be called, it calls automaticly by FakeTeam#spawn
    fun registerTeam(team: FakeTeam)

    fun getOrCreateTeam(player: Player, priority: Int, name: String): FakeTeam

    fun getPublicTeams(): Collection<FakeTeam>
}