package net.querix.api.server

import net.querix.api.server.game.GameInfo
import net.querix.api.server.mode.ServerMode
import net.querix.api.server.mode.ServerSubmode

interface Server {
    /**
     * returns something like "auth-1"
     */
    fun name(): String

    fun setData(key: String, value: Any)
    fun <T> getData(key: String, type: Class<T>, default: T): T


    fun online(): Int
    fun players(): List<String>

    fun gameInfo(): GameInfo

    fun mode(): ServerMode
    fun submode(): ServerSubmode
}