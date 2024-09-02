package net.querix.api.platform

import net.querix.api.language.Language


interface Platform {

    /**
     * This method must be implemented on each platform
     * to get the language [from] objects that exist only on that platform
     */
    fun getLanguage(from: Any): Language?

    fun isUserOnline(name: String): Boolean

    val serverAddress: String
    val serverPort: Int
    val serverMaxPlayers: Int
}