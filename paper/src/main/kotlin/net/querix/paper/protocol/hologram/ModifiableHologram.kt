package net.querix.paper.protocol.hologram

import net.querix.paper.protocol.hologram.line.ItemHologramLine
import net.querix.paper.protocol.hologram.line.TextHologramLine
import org.bukkit.inventory.ItemStack

interface ModifiableHologram : Hologram {
    /**
     * add [text] as next hologram line
     */
    fun appendText(text: String): TextHologramLine

    /**
     * add [itemStack] as next hologram line
     */
    fun appendItem(itemStack: ItemStack): ItemHologramLine
    fun insertText(beforeIndex: Int, text: String): TextHologramLine
    fun insertItem(beforeIndex: Int, itemStack: ItemStack): ItemHologramLine
    fun get(index: Int): HologramLine

    /**
     * remove line by index
     */
    fun remove(index: Int)
}