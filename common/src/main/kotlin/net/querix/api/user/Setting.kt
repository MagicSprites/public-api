package net.querix.api.user

enum class Setting (
    val defaultValue: Boolean,
    val group: String? = null,
    ) {
    HIDE_PLAYERS(false),
    WHISPER(false),
    DONATE_CHAT(false),
    GLOWING(true, "light"),
    FLY(true, "mercury"),
    CHAT_VISIBILITY(true),
//    FRIEND_INVITE(true),
//    PARTY_INVITE(true),
}