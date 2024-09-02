package net.querix.paper.scoreboard

import org.bukkit.entity.Player
import java.util.function.Function


interface Board {

    fun getLine(line: Int): String
    fun updateLine(line: Int, text: String)
    fun removeLine(line: Int)
    fun size(): Int
    fun getAnimation(): BoardAnimation
    fun setAnimation(animation: BoardAnimation, durationTick: Long): Board
    fun startUpdater(durationTick: Long): Board

    fun getTitle(): String
    fun updateTitle(title: String?)
    fun delete()

    /**
     * specify an placeholder, it will be updated every Board#startUpdater::durationTick
     */
    fun placeholder(placeholder: String, get: Function<Player, Any>): Board
}