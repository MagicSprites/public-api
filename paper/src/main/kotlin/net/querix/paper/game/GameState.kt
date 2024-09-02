package net.querix.paper.game

import net.querix.api.Querix
import net.querix.api.server.game.GameServerState
import net.querix.paper.util.lookupBukkitPlugin
import org.bukkit.Bukkit
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener

abstract class GameState(val stateType: GameServerState) : Listener {

    private val listeners: MutableList<Listener> = mutableListOf()

    abstract fun start()
    abstract fun end()

    fun service() : GameService {
        return Querix.lookupService<GameService>()
    }

    fun nextState() {
        service().nextState()
    }

    fun registerListener(listener: Listener) {
        listeners.add(listener)
        Bukkit.getServer().pluginManager.registerEvents(listener, lookupBukkitPlugin())
    }

    fun unregisterAllListeners() {
        HandlerList.unregisterAll(this)
    }
}