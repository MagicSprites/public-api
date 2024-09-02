@file:Suppress("NOTHING_TO_INLINE")

package net.querix.paper.extension

import net.querix.paper.utils.Utils
import java.time.Duration

import kotlin.collections.map

inline fun String.applyColors(): String {
    return Utils.applyColors(this)
}

inline fun Iterable<String>.applyColors(): List<String> {
    return map { it.applyColors() }
}

inline fun Number.secToTicks() = this.toLong() * 20
inline fun Number.ticksToSec() = this.toLong() / 20

inline fun Number.msToSecs() = this.toDouble() / 1000
inline fun Number.secsToMs() = this.toLong() * 1000


inline fun Number.ticksToMs() = this.toLong() * 50
inline fun Number.msToTicks() = this.toLong() / 50
inline fun Duration.toTicks() = this.toMillis().msToTicks()
inline fun Number.nanosToMs() = this.toDouble() / 1_000_000