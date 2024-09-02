package net.querix.api.util

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.WorldCreator
import org.bukkit.block.BlockFace
import java.util.*
import kotlin.math.floor

fun Location.parseString(): String {
    return String.format(
        "%s, %s, %s, %s, %s, %s", world.name,
        x, y, z, yaw, pitch
    )
}

fun String.parseLocation(): Location {
    val locData = split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val world = Bukkit.getWorld(locData[0])

    Objects.requireNonNull(world, "world")

    return Location(
        world, locData[1].toDouble(), locData[2].toDouble(), locData[3].toDouble(),
        locData[4].toFloat(), locData[5].toFloat()
    )
}

fun Location.centralizeXYZ(centerY: Boolean): Location  {
    val centralizedLocation = clone()

    centralizedLocation.x = floor(blockX.toDouble()) + 0.5
    centralizedLocation.z = floor(blockZ.toDouble()) + 0.5

    if (centerY)
        centralizedLocation.y = floor(blockY.toDouble()) + 0.5

    return centralizedLocation
}

val axis = arrayOf(BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST)
val radial = arrayOf(
    BlockFace.NORTH,
    BlockFace.NORTH_EAST,
    BlockFace.EAST,
    BlockFace.SOUTH_EAST,
    BlockFace.SOUTH,
    BlockFace.SOUTH_WEST,
    BlockFace.WEST,
    BlockFace.NORTH_WEST
)

fun yawToFace(yaw: Float): BlockFace {
    return yawToFace(yaw, true)
}

fun yawToFace(yaw: Float, useSubCardinalDirections: Boolean): BlockFace {
    return if (useSubCardinalDirections) {
        radial[Math.round(yaw / 45f) and 0x7]
    } else {
        axis[Math.round(yaw / 90f) and 0x3]
    }
}

fun loadWorld(world: String) {
    Bukkit.createWorld(WorldCreator(world));
}
