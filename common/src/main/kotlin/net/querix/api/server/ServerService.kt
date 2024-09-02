package net.querix.api.server

import net.querix.api.server.game.GameServerState
import net.querix.api.server.search.ServerSearchMode

interface ServerService {
    fun findServer(name: String): Server?
    fun findServer(prefix: String, searchMode: ServerSearchMode): Server?
    fun findServers(prefix: String): Collection<Server>
    fun findServers(): Collection<Server>


    fun getGameServer(name: String): Server?

    fun findGameServer(prefix: String, state: GameServerState, searchMode: ServerSearchMode): Server?

    fun findGameServers(prefix: String, state: GameServerState): Collection<Server>

}