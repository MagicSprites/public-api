package net.querix.api.storage

// for something like bestplayer
interface SingleDataStorage {
    fun put(key: String, data: String)
    fun remove(key: String): String?
    fun get(key: String): String?
}