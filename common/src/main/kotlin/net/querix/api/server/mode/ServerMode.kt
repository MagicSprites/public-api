package net.querix.api.server.mode



enum class ServerMode(val modeType: ModeType, val displayName: String, vararg val submodes: ServerSubmode) {
    HELL (
        ModeType.MAIN, "Hell",
        ServerSubmode("Hell", "hell")
    ),
    HUB (
        ModeType.MAIN, "Hub",

        ServerSubmode("Hub", "hub")
    ),

    AUTH (
        ModeType.MAIN, "Auth",

        ServerSubmode("Auth", "auth")
    ),

    ANARCHY (
        ModeType.SURVIVAL, "Anarchy",

        ServerSubmode("Anarchy", "anarchy")
    ),

    SKYBLOCK (
        ModeType.SURVIVAL, "SkyBlock",

        ServerSubmode("SkyBlock", "skyblock")
    ),

    BEDWARS (
        ModeType.GAME, "BedWars",

        ServerSubmode("BedWars Solo", "bws"),
        ServerSubmode("BedWars Doubles", "bwd"),
        ServerSubmode("BedWars Triples", "bwt"),
        ServerSubmode("BedWars Quad", "bwq")
    ),

    PIGWARS (
        ModeType.GAME, "PigWars",

        ServerSubmode("PigWars Solo", "pws"),
        ServerSubmode("PigWars Doubles", "pwd"),
        ServerSubmode("PigWars Triples", "pwt"),
        ServerSubmode("PigWars Quad", "pwq")
    ),

    FLAPPY_BIRD(
        ModeType.GAME, "Flappy Bird",
        ServerSubmode("Flappy Bird", "flappybird"),
    ),

    DUELS (
        ModeType.GAME, "Duels",

        ServerSubmode("Fireball Fight", "fbf"),
        ServerSubmode("Stick Fight", "stf"),
        ServerSubmode("Sumo Fight", "smf"),
    ),
    ;

    companion object {
        fun findSubmode(prefix: String): ServerSubmode? {
            for (mode in entries)
                for (submode in mode.submodes)
                    if (prefix.lowercase().startsWith(submode.prefix.lowercase()))
                        return submode

            return null
        }
    }
}