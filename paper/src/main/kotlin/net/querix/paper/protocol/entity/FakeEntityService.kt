package net.querix.paper.protocol.entity

interface FakeEntityService {
    /**
     * create entity builder
     */
    fun createBuilder(): FakeEntityBuilder
}