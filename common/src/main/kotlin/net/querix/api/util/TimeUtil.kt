package net.querix.api.util

import net.querix.api.language.Language

fun Int.formatTime(language: Language): String {
    var seconds = this
    var minutes = 0
    var hours = 0
    var days = 0
    var weeks = 0
    var months = 0
    var years = 0

    if (seconds >= 60) {
        val i = seconds / 60
        seconds -= 60 * i
        minutes += i
    }

    if (minutes >= 60) {
        val i = minutes / 60
        minutes -= 60 * i
        hours += i
    }

    if (hours >= 24) {
        val i = hours / 24
        hours -= 24 * i
        days += i
    }

    if (days >= 7) {
        val i = days / 7
        days -= 7 * i
        weeks += i
    }

    if (weeks >= 4) {
        val i = weeks / 4
        weeks -= 4 * i
        months += i
    }

    if (months >= 12) {
        val i = months / 12
        months -= 12 * i
        years += i
    }

    val builder = StringBuilder()

    if (years != 0) {
        builder.append(years.format(NumberUnit.YEARS, language)).append(" ")
    }

    if (months != 0) {
        builder.append(months.format(NumberUnit.MONTHS, language)).append(" ")
    }

    if (weeks != 0) {
        builder.append(weeks.format(NumberUnit.WEEKS, language)).append(" ")
    }

    if (days != 0) {
        builder.append(days.format(NumberUnit.DAYS, language)).append(" ")
    }

    if (hours != 0) {
        builder.append(hours.format(NumberUnit.HOURS, language)).append(" ")
    }

    if (minutes != 0) {
        builder.append(minutes.format(NumberUnit.MINUTES, language)).append(" ")
    }

    if (seconds != 0) {
        builder.append(seconds.format(NumberUnit.SECONDS, language))
    }

    return builder.toString()
}

fun Long.formatTime(language: Language): String {
    return (this / 1000).toInt().formatTime(language)
}