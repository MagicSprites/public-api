package net.querix.api.user

import net.querix.api.language.Language
import net.querix.api.user.objects.Setting
import net.querix.api.user.objects.Skin
import java.util.UUID

interface User {
    fun prefix(): String
    fun prefix(prefix: String): String

    fun suffix(): String
    fun suffix(suffix: String): String

    fun uniqueId(): UUID
    fun name(): String

    fun clearPrefix()

    fun groupPrefix(): String

    fun hasGroup(group: String): Boolean

    fun language(): Language
    fun language(language: Language)

    fun coins(): Int
    fun coins(coins: Int)
    fun takeCoins(coins: Int)
    fun giveCoins(coins: Int)
    fun hasCoins(coins: Int): Boolean

    fun crystals(): Int
    fun crystals(crystals: Int)
    fun takeCrystals(crystals: Int)
    fun giveCrystals(crystals: Int)
    fun hasCrystals(coins: Int): Boolean

    fun level(): Int
    fun nextLevel(): Int
    fun experience(): Int
    fun addExperience(experience: Int)
    fun setLevel(level: Int)

    fun skin(): String
    fun skin(skin: String)

    fun playedTime(): Long
    fun addPlayedTime(time: Long)

    fun skinModel(): Skin

    fun redirect(prefix: String)

    fun weight(): Int

    fun setting(setting: Setting, value: Boolean)
    fun setting(setting: Setting): Boolean
}