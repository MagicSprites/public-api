package net.querix.api.user

import java.util.UUID
import java.util.function.Consumer

interface UserService {

    fun lookupUniqueId(username: String): UUID
    fun getUser(id: UUID): User
    fun getUser(username: String): User

    /**
     * fetches the user data for the given username even
     * if the user is not online
     */
    fun getUserData(username: String, loader: Consumer<User>)
}