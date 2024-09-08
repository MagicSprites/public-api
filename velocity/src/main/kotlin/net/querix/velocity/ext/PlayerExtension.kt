package net.querix.velocity.ext

import com.velocitypowered.api.proxy.Player
import net.querix.api.user.User
import net.querix.api.user.UserService
import net.querix.api.util.resolve

fun Player.user() : User {
    return resolve<UserService>().getUser(username)
}