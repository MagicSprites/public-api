package net.querix.paper.protocol

class VisibleEntityService {
    val list: MutableList<VisibleEntity> = mutableListOf()

    fun register(entity: VisibleEntity) {
        list.add(entity)
    }

    fun unregister(entity: VisibleEntity) {
        list.remove(entity)
    }
}