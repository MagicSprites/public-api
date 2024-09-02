package net.querix.paper.scoreboard.animation

import net.querix.paper.scoreboard.BoardAnimation

/**
 * base scoreboard title animation, like in a
 * lastcraft (mc.lastcraft.net)
 */
class ShiftBoardAnimation(displayName: String) : BoardAnimation {

    private var displayAnimation: MutableList<String>
    private var displayCounter = 0
    private lateinit var currentDisplay: String

    override fun nextDisplay() {
        this.currentDisplay = displayAnimation[displayCounter]
        displayCounter++

        if (displayCounter >= displayAnimation.size)
            displayCounter = 0
    }

    // dynomake: do not try to understand and do not look at this!!!
    fun getAnimation(displayName: String): MutableList<String> {
        val animation: MutableList<String> = ArrayList()

        val displayLine = "$displayName  "
        val displayInfoArray = displayLine.toCharArray()
        val displayWorkArray = CharArray(displayInfoArray.size)
        var slotTextSee = 0

        for (sym in displayInfoArray) {
            var slot = displayInfoArray.size - 1
            for (g in 0 until getSizeCharArray(displayWorkArray)) {
                val line = StringBuilder()
                for (i in displayInfoArray.indices) {
                    if (displayWorkArray[i].code == 0) {
                        if (i == slot) {
                            if (i == slotTextSee) {
                                displayWorkArray[slotTextSee] = sym
                                line.append(sym)
                                slotTextSee++
                            } else {
                                line.append("§3§l").append(sym)
                                slot -= 1
                            }
                        } else {
                            line.append(" ")
                        }
                    } else {
                        line.append(displayWorkArray[i])
                    }
                }

                animation.add(" §8§l» §b§l$line")
            }
        }

        return animation
    }

    private fun getSizeCharArray(array: CharArray): Int {
        var i = 0
        for (arr in array) {
            if (arr.code == 0) {
                i++
            }
        }
        return i
    }

    override fun getDisplayAnimation(): Collection<String> {
        return displayAnimation
    }

    override fun getCurrentDisplay(): String {
        return currentDisplay
    }

    init {
        displayAnimation = getAnimation(displayName)
        val lastString = displayAnimation[displayAnimation.size - 1]
        for (i in 0..119)
            displayAnimation.add(lastString)
    }
}