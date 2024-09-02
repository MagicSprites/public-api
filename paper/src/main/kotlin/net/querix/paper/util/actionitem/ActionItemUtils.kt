package net.querix.paper.util.actionitem

import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

lateinit var actionItemKey: NamespacedKey
val actionItemMap = mutableMapOf<String, ActionItem>()

fun ItemStack.isActionItem(): Boolean{
    return itemMeta != null && itemMeta.persistentDataContainer.has(actionItemKey, PersistentDataType.STRING)
}

fun ItemStack.getActionItem(): ActionItem? {
    return if (isActionItem())
        actionItemMap[itemMeta.persistentDataContainer.get(actionItemKey, PersistentDataType.STRING)]
        else
            null

}