@file:Suppress("NOTHING_TO_INLINE")

package net.querix.paper.extension

import org.bukkit.command.CommandSender

inline fun CommandSender.sendSimpleMessage(message: String) {
    sendMessage(message.applyColors())
}