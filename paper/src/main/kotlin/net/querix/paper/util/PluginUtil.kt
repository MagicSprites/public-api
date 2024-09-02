package net.querix.paper.util

import net.querix.api.util.lookupService
import org.bukkit.plugin.java.JavaPlugin

/**
 * Do not register this service!
 */
fun lookupBukkitPlugin(): JavaPlugin {
    return lookupService<JavaPlugin>()
}