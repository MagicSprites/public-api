package net.querix.paper.scoreboard

/**
 * scoreboard title animation interface
 * you can extend it if you want something fantastic
 *
 * written by dynomake
 */
interface BoardAnimation {
    /**
     * returns an ordered list with title animation
     */
    fun getDisplayAnimation(): Collection<String>

    /**
     * returns a current title for the scoreboard
     */
    fun getCurrentDisplay(): String

    /**
     * change title to next
     */
    fun nextDisplay()
}