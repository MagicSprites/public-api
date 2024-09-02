package net.querix.api.server.search

import net.querix.api.server.Server

enum class ServerSearchMode(
    val function: (Collection<Server>) -> Server?
) {
    MINIMAL_ONLINE({
        var min: Server? = null
        for (server in it)
            if (min == null || min!!.online() > server.online())
                min = server

        min
    }),

    MAXIMAL_ONLINE({
        var max: net.querix.api.server.Server? = null
        for (server in it)
            if (max == null || max!!.online() < server.online())
                max = server

        max
    }),

    RANDOM({ it.random() }),
    ;
}