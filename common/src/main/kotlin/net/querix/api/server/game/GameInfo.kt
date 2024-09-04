package net.querix.api.server.game


interface GameInfo {
    fun serverState(): GameServerState?
    fun serverState(state: GameServerState)

}