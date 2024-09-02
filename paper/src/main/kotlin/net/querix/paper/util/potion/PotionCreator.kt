package net.querix.paper.util.potion

import org.bukkit.potion.PotionEffect
import java.util.*

class PotionCreator private constructor() {
    private var id: String = UUID.randomUUID().toString()
    private var name: String? = null
    private var color: PotionHeadColor = PotionHeadColor.RAINBOW
    private val effects: MutableList<PotionEffect> = mutableListOf()

    fun id(id: String): PotionCreator {
        this.id = id
        return this
    }

    fun name(name: String): PotionCreator {
        this.name = name
        return this
    }

    fun color(color: PotionHeadColor): PotionCreator {
        this.color = color
        return this
    }

    fun effect(effect: PotionEffect): PotionCreator {
        effects.add(effect)

        return this
    }

    fun create(): InstantPotionItem {
        return InstantPotionItem(id, name, color, effects)
    }

    companion object {
        fun another() = PotionCreator()
    }
}