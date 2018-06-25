package com.xznn.bean

data class OrderItemBean(var id: Int, var product: ProductBean, var num: Int, var orderBean: OrderBean?) {
    constructor(product: ProductBean, num: Int): this(0, product, num, null)
}