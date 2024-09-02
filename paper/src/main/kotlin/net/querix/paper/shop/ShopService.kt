package net.querix.paper.shop

interface ShopService {
    fun getType(id: String): ShopType
}