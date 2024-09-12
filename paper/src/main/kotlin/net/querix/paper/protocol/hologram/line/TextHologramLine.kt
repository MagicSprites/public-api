package net.querix.paper.protocol.hologram.line

import net.querix.paper.protocol.hologram.HologramLine

interface TextHologramLine : HologramLine {
    fun getText(): String
    fun setText(text: String)
}