package net.querix.paper.gui

import net.querix.paper.gui.impl.ChestGui
import org.bukkit.entity.Player

val guiMap = mutableMapOf<Player, Menu>()

fun chestMenu(payer: Player, title: String, rows: Int, init: ChestGui.() -> Unit): ChestGui {
    val gui = ChestGui(title, rows)
    gui.init()
    guiMap[payer] = gui
    return gui
}