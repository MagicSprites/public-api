package net.querix.api.server

import net.querix.api.server.game.GameServerState
import net.querix.api.server.mode.ServerMode
import net.querix.api.server.mode.ServerSubmode
import net.querix.api.server.search.ServerSearchMode

interface ServerService {
    fun findServer(name: String): Server?
    fun findServer(prefix: String, searchMode: ServerSearchMode): Server?
    fun findServers(prefix: String): Collection<Server>
    fun findServers(mode: ServerMode): Collection<Server>
    fun findServers(mode: ServerSubmode): Collection<Server>
    fun findServer(mode: ServerSubmode, searchMode: ServerSearchMode): Server?
    fun findServer(mode: ServerMode, searchMode: ServerSearchMode): Server?


    fun getGameServer(name: String): Server?

    fun findGameServer(prefix: String, state: GameServerState, searchMode: ServerSearchMode): Server?

    fun findGameServers(prefix: String, state: GameServerState): Collection<Server>


    fun currentServer(): Server?
}