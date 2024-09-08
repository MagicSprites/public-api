package net.querix.api

@Suppress("MemberVisibilityCanBePrivate")
class DependencyContainer(
) {

    companion object {
        val dependencies = mutableMapOf<String, Any>()

        inline fun <reified Type> resolve(): Type {
            return dependencies[Type::class.java.name] as Type
        }

        inline fun <reified Type : Any> register(service: Type) {
            dependencies[Type::class.java.name] = service
            dependencies[service::class.java.name] = service
        }
    }
}