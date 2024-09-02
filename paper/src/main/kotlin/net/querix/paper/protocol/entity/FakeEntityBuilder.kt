package net.querix.paper.protocol.entity

import net.querix.paper.protocol.entity.data.FakeClickType
import net.querix.paper.protocol.entity.data.FakeEntityType
import net.querix.paper.protocol.entity.data.FakeEquipmentItemSlot
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.function.Consumer


interface FakeEntityBuilder {
    /**
     * identifier can't be duplicate,
     * you need to use unique every moment where you create npc
     *
     * if you dont wanna watch for it, use FakeEntityBuilder#withRandomIdentifier
     */
    fun withIdentifier(id: Int): FakeEntityBuilder
    fun withRandomIdentifier(): FakeEntityBuilder

    fun withRefreshSkinDuration(refreshSkinDuration: Int): FakeEntityBuilder
    fun addClickAction(clickType: FakeClickType, clickAction: Consumer<Player>): FakeEntityBuilder

    fun withEquip(slot: FakeEquipmentItemSlot, item: ItemStack): FakeEntityBuilder
    fun withLocation(location: Location): FakeEntityBuilder
    fun withType(npcType: FakeEntityType): FakeEntityBuilder
    fun withSignature(signature: String): FakeEntityBuilder
    fun withTexture(texture: String): FakeEntityBuilder
    fun create(): FakeEntity;
}