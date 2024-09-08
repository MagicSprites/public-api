package net.querix.paper.util

import net.querix.api.util.resolve
import org.bukkit.plugin.java.JavaPlugin

/**
 * Do not register this service!
 */
fun lookupBukkitPlugin(): JavaPlugin {
    return resolve<JavaPlugin>()
}