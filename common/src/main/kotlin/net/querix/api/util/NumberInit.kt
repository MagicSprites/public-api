package net.querix.api.util

import net.querix.api.language.Language

enum class NumberInit {
    COINS,
    CRYSTALS,

    SECONDS,
    MINUTES,
    HOURS,
    DAYS,
    WEEKS,
    MONTHS,
    YEARS;

    fun one(lang: Language): String {
        return lang.getString("formatting.${this.name.lowercase()}_one")
    }

    fun two(lang: Language): String {
        return lang.getString("formatting.${this.name.lowercase()}_two")
    }

    fun others(lang: Language): String {
        return lang.getString("formatting.${this.name.lowercase()}_others")
    }
}