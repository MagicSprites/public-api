@file:Suppress("NOTHING_TO_INLINE")

package net.querix.paper.extension

import com.mojang.authlib.GameProfile
import com.mojang.authlib.properties.Property
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.potion.PotionEffect
import java.util.UUID

// do not ask, it needs for builder pattern
inline fun ItemStack.setStackAmount(amount: Int): ItemStack {
    setAmount(amount)
    return this
}

inline fun ItemStack.editMeta(func: ItemMeta.() -> Unit) {
    val meta = itemMeta
    func(meta)
    itemMeta = meta
}

inline fun ItemStack.setDisplayName(name: String?): ItemStack {
    if (name != null)
        editMeta {
            it.setDisplayName(name.applyColors())
        }

    return this
}

// do not ask, it needs for builder pattern
inline fun ItemStack.setDurability(durability: Short): ItemStack {
    this.durability = durability
    return this
}

inline val ItemStack.displayName: String
    get() = itemMeta.displayName

inline fun ItemStack.setLore(lore: List<String>): ItemStack {
    editMeta {
        this.lore = lore.map(String::applyColors)
    }
    return this
}

inline fun ItemStack.setLore(lore: String): ItemStack {
    setLore(lore.split("\n"))
    return this
}

inline fun ItemStack.addLore(lines: List<String>): ItemStack {
    val currentLore = this.lore
    val newLore = currentLore?.toMutableList() ?: mutableListOf()
    newLore.addAll(lines)
    setLore(newLore)
    return this
}

inline fun ItemStack.addLore(lore: String) = addLore(lore.split("\n"))

inline var ItemStack.lore: MutableList<String>
    get() = itemMeta.lore ?: mutableListOf()
    set(value) {
        setLore(value)
    }

fun ItemStack.addPotionEffect(effect: PotionEffect): ItemStack {
    editMeta {
        if (it is PotionMeta)
            it.addCustomEffect(effect, false)
    }

    return this
}

fun ItemStack.setTexture(texture: String): ItemStack {
    editMeta {
        if (it is SkullMeta) {
            val profile = GameProfile(UUID.randomUUID(), null)
            profile.properties.put("textures", Property("textures", texture))
            try {
                val profileField = it.javaClass.getDeclaredField("profile")
                profileField.setAccessible(true)
                profileField.set(it, profile)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    return this
}

fun ItemStack.setGlow(toggle: Boolean): ItemStack {
    val glowEnchantment = Enchantment.ARROW_DAMAGE

    if (toggle) {
        addFlag(ItemFlag.HIDE_ENCHANTS);
        enchant(glowEnchantment, 1);
    } else {
        removeFlag(ItemFlag.HIDE_ENCHANTS);

        editMeta {
            if (!it.hasEnchant(glowEnchantment) || it.hasConflictingEnchant(glowEnchantment))
                return@editMeta

            it.removeEnchant(glowEnchantment)
        }
    }

    return this
}

fun ItemStack.addFlag(flag: ItemFlag): ItemStack {
    editMeta {
        it.addItemFlags(flag)
    }

    return this
}

fun ItemStack.removeFlag(flag: ItemFlag): ItemStack {
    editMeta {
        if (it.hasItemFlag(flag))
            it.removeItemFlags(flag)
    }

    return this
}

fun ItemStack.enchant(enchant: Enchantment, level: Int): ItemStack {
    addUnsafeEnchantment(enchant, level)
    return this
}


fun ItemStack.setSkullOwner(owner: String): ItemStack {
    editMeta {
        if (it is SkullMeta)
            it.setOwner(owner)
    }

    return this
}

inline val Material.isAir: Boolean
    get() = this == Material.AIR

inline val ItemStack.isAir: Boolean
    get() = type.isAir

inline fun ItemStack?.equalsByAppearance(item: ItemStack?): Boolean {
    if (this == null || item == null) return false
    val type1 = this.type
    val type2 = item.type
    val meta1 = this.itemMeta
    val meta2 = item.itemMeta
    val display1 = meta1!!.displayName
    val display2 = meta2!!.displayName
    return type1 == type2 && display1 == display2
}
