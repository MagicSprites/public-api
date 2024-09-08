package net.querix.api.util

import net.querix.api.DependencyContainer

inline fun <reified Type> resolve(): Type {
    return DependencyContainer.dependencies[Type::class.java.name] as Type
}

inline fun <reified T : Any> inject(): Lazy<T> = lazy {
    resolve<T>()
}

