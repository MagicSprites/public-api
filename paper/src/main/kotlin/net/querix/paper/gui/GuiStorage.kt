package net.querix.paper.gui

import net.querix.paper.gui.impl.ChestGui
import net.querix.paper.gui.impl.PaginatedChestGui
import org.bukkit.entity.Player
import java.util.function.Consumer

val guiMap = mutableMapOf<Player, Menu>()

fun chestMenu(payer: Player, title: String, rows: Int, init: ChestGui.() -> Unit): ChestGui {
    val gui = ChestGui(title, rows)
    gui.init()
    return gui
}

fun chestMenu(payer: Player, title: String, rows: Int, init: Consumer<ChestGui>): ChestGui {
    val gui = ChestGui(title, rows)

    init.accept(gui)

    return gui
}

fun paginatedChestMenu(player: Player, title: String, rows: Int, init: PaginatedChestGui.() -> Unit): PaginatedChestGui {
    val gui = PaginatedChestGui(title, rows)
    gui.init()
    return gui
}

fun paginatedChestMenu(player: Player, title: String, rows: Int, init: Consumer<PaginatedChestGui>): PaginatedChestGui {
    val gui = PaginatedChestGui(title, rows)

    init.accept(gui)

    return gui
}



