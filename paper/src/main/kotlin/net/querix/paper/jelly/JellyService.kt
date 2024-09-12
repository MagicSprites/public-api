package net.querix.paper.jelly

/**
 * why?
 * in server type plugin you should
 * register functions if you wanna
 */
interface JellyService {

    fun registerAutoUpdatingTeams()
    fun disableWeatherChange()
    fun disableTimeChange(time: Int)
    fun disableWorldChange()

    fun registerProfile()
    fun registerShops()
    fun registerJoiners()
}