package net.querix.api

@Suppress("MemberVisibilityCanBePrivate")
class Querix(
) {

    companion object {
        private lateinit var querix: Querix;
        val serviceMap = mutableMapOf<String, Any>()

        fun instance(): Querix {
            return querix
        }

        inline fun <reified Type> lookupService(): Type {
            return serviceMap[Type::class.java.name] as Type
        }

        inline fun <reified Type : Any> registerService(service: Type) {
            serviceMap[Type::class.java.name] = service
            serviceMap[service::class.java.name] = service
        }
    }
}