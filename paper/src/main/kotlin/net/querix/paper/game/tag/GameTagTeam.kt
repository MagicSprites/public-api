package net.querix.paper.game.tag

import net.querix.api.util.inject
import net.querix.paper.protocol.team.FakeTeamService
import net.querix.api.util.randomString
import org.bukkit.entity.Player

val tagTeams: MutableSet<GameTagTeam> = mutableSetOf()

class GameTagTeam (allies: List<Player>, oppenents: List<Player>) {
    private val teamService: FakeTeamService by inject()

    private val alliesProtocolTeam = teamService.createTeam(100, randomString(6))
    private val opponentsProtocolTeam = teamService.createTeam(10, randomString(6))

    init {
        alliesProtocolTeam.setPrefix("§b")
        for (player in allies)
            alliesProtocolTeam.addPlayer(player)

        opponentsProtocolTeam.setPrefix("§c")
        for (player in oppenents)
            opponentsProtocolTeam.addPlayer(player)
    }

    fun apply(player: Player) {
        tagTeams.add(this)

        alliesProtocolTeam.addViewer(player)
        opponentsProtocolTeam.addViewer(player)
    }

    fun remove(player: Player) {
        alliesProtocolTeam.deleteViewer(player)
        opponentsProtocolTeam.deleteViewer(player)
    }

    fun removeForAll() {
        for (player in alliesProtocolTeam.getViewers().toList())
            alliesProtocolTeam.deleteViewer(player)

        for (player in opponentsProtocolTeam.getViewers().toList())
            opponentsProtocolTeam.deleteViewer(player)
    }
}

fun removeAllTagTeams() {
    for (tag in tagTeams)
        tag.removeForAll()

    tagTeams.clear()
}