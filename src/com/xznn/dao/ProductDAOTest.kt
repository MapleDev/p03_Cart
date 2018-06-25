package com.xznn.dao


import org.junit.Test


class ProductDAOTest {
    @Test
    @Throws(Exception::class)
    fun getProductList() {
        val products = ProductDAO().getProductList()
        println("products = " + products.size)
    }
}