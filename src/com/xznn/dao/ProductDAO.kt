package com.xznn.dao

import com.xznn.bean.ProductBean
import com.xznn.bean.UserBean
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*


class ProductDAO {

    fun getUserById(id: Int): ProductBean? {
        var productBean:ProductBean? = null

        var ps: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            Class.forName("com.mysql.jdbc.Driver")
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?characterEncoding=UTF-8", "root", "gakii")
            val sql = "select * from product where id = ?"
            ps = connection.prepareStatement(sql)
            ps.setInt(1, id)
            rs = ps.executeQuery()
            while (rs.next()) {
//                val idRst = rs.getInt("id")
                val nameRst = rs.getString("name")
                val priceRst = rs.getFloat("price")
                productBean = ProductBean(id, nameRst, priceRst)
            }

        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            rs?.close()
            ps?.close()
        }

        return productBean
    }

    fun getProductList(): ArrayList<ProductBean> {

        val productList = ArrayList<ProductBean>()

        var ps: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            Class.forName("com.mysql.jdbc.Driver")
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?characterEncoding=UTF-8", "root", "gakii")
            val sql = "select * from product order by id desc"
            ps = connection.prepareStatement(sql)
            rs = ps.executeQuery()
            while (rs.next()) {
                val id = rs.getInt("id")
                val name = rs.getString("name")
                val price = rs.getFloat("price")
                val productBean = ProductBean(id, name, price)
                productList.add(productBean)
            }

        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            rs?.close()
            ps?.close()
        }

        return productList
    }

}