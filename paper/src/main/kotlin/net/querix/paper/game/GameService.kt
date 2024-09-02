package net.querix.paper.game

interface GameService {
    fun registerDefaultWaiting()
    fun registerDefaultEnding()

    fun registerState(state: GameState)
    fun nextState()
    fun currentState(): GameState

    fun initGameServer(maxPlayers: Int, minPlayers: Int, mapName: String)

    fun map(): String
    fun gameId(): String
    fun maxPlayers(): Int
    fun minPlayers(): Int

    fun winners(players: List<String>)
    fun winners(): List<String>

}