package net.querix.api.util

import net.querix.api.Querix

inline fun <reified Type> lookupService(): Type {
    return Querix.serviceMap[Type::class.java.name] as Type
}