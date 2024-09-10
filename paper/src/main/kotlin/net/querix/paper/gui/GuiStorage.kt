package net.querix.paper.gui

import net.querix.paper.gui.impl.ChestGui
import org.bukkit.entity.Player
import java.util.function.Consumer

val guiMap = mutableMapOf<Player, Menu>()

fun chestMenu(payer: Player, title: String, rows: Int, init: ChestGui.() -> Unit): ChestGui {
    val gui = ChestGui(title, rows)
    gui.init()
    guiMap[payer] = gui
    return gui
}

fun chestMenu(payer: Player, title: String, rows: Int, init: Consumer<ChestGui>): ChestGui {
    val gui = ChestGui(title, rows)

    init.accept(gui)

    guiMap[payer] = gui
    return gui
}