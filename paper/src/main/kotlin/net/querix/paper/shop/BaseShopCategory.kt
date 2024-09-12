package net.querix.paper.shop


interface BaseShopCategory : ShopCategory {
    val id: String
    val typeId: String
    val items: MutableList<ShopElement>

    override fun items(): Collection<ShopElement> {
        return items
    }

    override fun addElement(element: ShopElement) {
        items.add(element)
    }

    override fun categoryId(): String {
        return id
    }

    override fun typeId(): String {
        return typeId
    }
}