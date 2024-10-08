package net.querix.paper.gui.impl

import net.querix.paper.gui.Slots
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.function.Consumer

class PaginatedChestGui(title: String, rows: Int) : ChestGui(title, rows) {
    private val markupSlots = mutableListOf<Int>()
    private val markupItems = mutableListOf<Pair<ItemStack, Consumer<Player>?>>()
    private var currentPage = 0

    fun addMarkupSlot(slot: Int) {
        markupSlots.add(slot)
    }

    fun addMarkupSlot(slot: Slots) {
        addMarkupSlot(slot.ordinal)
    }

    fun setMarkupSlots(vararg slots: Int) {
        markupSlots.clear()
        markupSlots.addAll(slots.toList())
    }

    fun setMarkupSlots(vararg slots: Slots) {
        markupSlots.clear()
        markupSlots.addAll(slots.map { it.ordinal })
    }

    fun addMarkupItem(item: ItemStack) {
        markupItems.add(Pair(item, null))
    }

    fun addMarkupItem(item: ItemStack, action: Consumer<Player>) {
        markupItems.add(Pair(item, action))
    }

    fun updatePage() {
        // Очищаем инвентарь
        inventory.clear()
        itemActionMap.clear()

        // Вычисляем начальный индекс для текущей страницы
        val startIndex = currentPage * markupSlots.size

        // Заполняем слоты текущей страницы
        for (i in markupSlots.indices) {
            val itemIndex = startIndex + i
            if (itemIndex < markupItems.size) {
                val item = markupItems[itemIndex]
                setItem(markupSlots[i], item.first) { player ->
                    if (item.second != null)
                        item.second?.accept(player)
                }
            }
        }

        if (currentPage > 0) {
            setItem(inventory.size - 9, createNavigationItem("§eНазад")) { player ->
                currentPage--
                updatePage()
                open(player)
            }
        }

        if ((currentPage + 1) * markupSlots.size < markupItems.size) {
            setItem(inventory.size - 1, createNavigationItem("§eВперед")) { player ->
                currentPage++
                updatePage()
                open(player)
            }
        }
    }

    private fun createNavigationItem(name: String): ItemStack {
        val item = ItemStack(Material.ARROW)
        val meta = item.itemMeta

        meta?.setDisplayName(name)
        item.itemMeta = meta
        return item
    }

    override fun open(player: Player) {
        updatePage()
        super.open(player)
    }
}