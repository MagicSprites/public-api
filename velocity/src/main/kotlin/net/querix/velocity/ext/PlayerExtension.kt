package net.querix.velocity.ext

import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import net.querix.api.server.ServerService
import net.querix.api.server.mode.ServerMode
import net.querix.api.server.mode.ServerSubmode
import net.querix.api.server.search.ServerSearchMode
import net.querix.api.user.User
import net.querix.api.user.UserService
import net.querix.api.util.resolve

fun Player.user() : User {
    return resolve<UserService>().getUser(username)
}

fun User.velocity() : Player {
    return resolve<ProxyServer>().getPlayer(name()).get()
}

fun Player.redirect(prefixOrName: String) {
    user().redirect(prefixOrName)
}

fun Player.redirect(serverMode: ServerMode, searchMode: ServerSearchMode) {
    resolve<ServerService>().findServer(serverMode, searchMode)?.name()?.let { redirect(it) }
}

fun Player.redirect(serverMode: ServerMode) {
    redirect(serverMode, ServerSearchMode.MINIMAL_ONLINE)
}

fun Player.redirect(serverMode: ServerSubmode, searchMode: ServerSearchMode) {
    resolve<ServerService>().findServer(serverMode, searchMode)?.name()?.let { redirect(it) }
}

fun Player.redirect(serverMode: ServerSubmode) {
    redirect(serverMode, ServerSearchMode.MINIMAL_ONLINE)
}

fun Player.redirect(prefix: String, searchMode: ServerSearchMode) {
    resolve<ServerService>().findServer(prefix, searchMode)?.name()?.let { redirect(it) }
}
