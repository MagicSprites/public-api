package net.querix.api.util

import net.querix.api.language.Language

fun Int.format(numberUnit: NumberUnit, language: Language): String {
    if (this % 100 in 11..14) {
        return "$this ${numberUnit.others(language)}"
    }
    return when (this % 10) {
        1 -> { "$this ${numberUnit.one(language)}" }
        2, 3, 4 -> { "$this ${numberUnit.two(language)}" }
        else -> { "$this ${numberUnit.others(language)}" }
    }
}

fun randomString(length: Int) : String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}