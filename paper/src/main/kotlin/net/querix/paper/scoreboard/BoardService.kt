package net.querix.paper.scoreboard

import org.bukkit.entity.Player

interface BoardService {
    /**
     * if you created a scoreboard for a [player] through this
     * service, you can destroy it here
     */
    fun removeBoard(player: Player)

    /**
     * if you created a scoreboard for a [player] through this
     * service, you can get it here
     */
    fun getBoard(player: Player): Board?

    /**
     * creating a scoreboard for the [player] is possible only
     * with the needed argument of the [key] in the language
     */
    fun createBoard(key: String, player: Player): Board
}