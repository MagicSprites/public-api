package net.querix.paper.extension

import net.kyori.adventure.text.Component
import net.querix.api.language.lang
import net.querix.api.server.ServerService
import net.querix.api.server.mode.ServerMode
import net.querix.api.server.mode.ServerSubmode
import net.querix.api.server.search.ServerSearchMode
import net.querix.paper.protocol.team.FakeTeamService
import net.querix.api.user.User
import net.querix.api.user.UserService
import net.querix.api.util.resolve
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player

fun Player.clearActivePotionEffects() {
    activePotionEffects.forEach { removePotionEffect(it.type) }
}

fun Player.reset(mode: GameMode) {
    inventory.clear()

    getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue = 20.0
    health = 20.0

    foodLevel = 20
    gameMode = mode

    clearActivePotionEffects()
}

fun Player.msg(message: String) {
    sendMessage(Component.text(message))
}

fun Player.sendLangMessage(key: String) {
    sendMessage(lang(key, this))
}

fun Player.createDefaultTeam() {
    val user = user()
    val team = resolve<FakeTeamService>().createTeam(user.weight(), this.name)

    team.setPrefix(user.prefix())
    team.setSuffix(user.suffix())
    team.addPlayer(this)

    team.spawn()
}

fun Player.user() : User {
    return resolve<UserService>().getUser(name)
}

fun User.bukkit() : Player {
    return Bukkit.getPlayerExact(name())!!
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