package net.querix.paper.extension

import org.bukkit.Bukkit
import org.bukkit.Location

fun String.toLocation(): Location? {

    val locData = this.split(", ")
    val world = Bukkit.getWorld(locData[0]) ?: return null

    return Location(
        world,
        locData[1].toDouble(),
        locData[2].toDouble(),
        locData[3].toDouble(),
        locData[4].toFloat(),
        locData[5].toFloat()
    )
}

fun Location?.toLocationString(): String? {
    if (this == null) return null

    return listOf(
        this.world?.name,
        this.x,
        this.y,
        this.z,
        this.yaw,
        this.pitch
    ).joinToString(", ")
}
