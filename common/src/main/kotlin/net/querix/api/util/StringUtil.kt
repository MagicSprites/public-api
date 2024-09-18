package net.querix.api.util

import gnu.trove.map.hash.TObjectIntHashMap
import net.querix.api.language.Language
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong
import java.util.regex.Pattern

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

val TIME_TO_MILLIS_PATTERN =
    Pattern.compile("(?i)" + "(\\d{1,3}(?=ns))?" + "(\\d{1,3}(?=mc))?" + "(\\d{1,3}(?=ms))?" + "(\\d{1,3}(?=s))?" + "(\\d{1,3}(?=m))?" + "(\\d{1,3}(?=h))?" + "(\\d{1,3}(?=d))?" + "(\\d{1,3}(?=w))?")

fun String.parseTime(unitTo: TimeUnit): Long {
    if (startsWith("-a")) {
        return -1
    }

    val matcher = TIME_TO_MILLIS_PATTERN.matcher(this)
    val values = TObjectIntHashMap<TimeUnit>()

    while (matcher.find()) {
        for (i in 1..7) {
            val value: String? = matcher.group(i)

            if (value.isNullOrEmpty()) {
                continue
            }

            val unit = TimeUnit.entries[i - 1]
            val intValue = value.toInt()

            values.adjustOrPutValue(unit, intValue, intValue)
            break
        }
    }

    require(!values.isEmpty()) { "Illegal Date" }

    val total = AtomicLong()

    values.forEachEntry { timeUnit, value ->
        total.addAndGet(unitTo.convert(value.toLong(), timeUnit))
        true
    }

    require(total.get() > 0) { "Illegal Date" }

    return total.get()
}