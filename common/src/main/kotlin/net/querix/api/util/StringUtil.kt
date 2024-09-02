package net.querix.api.util

import net.querix.api.language.Language

fun Int.format(numberInit: NumberInit, language: Language): String {
    if (this % 100 in 11..14) {
        return "$this ${numberInit.others(language)}"
    }
    return when (this % 10) {
        1 -> {
            "$this ${numberInit.one(language)}"
        }

        2, 3, 4 -> {
            "$this ${numberInit.two(language)}"
        }

        else -> {
            "$this ${numberInit.others(language)}"
        }
    }
}