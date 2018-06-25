package com.xznn.dao

import com.xznn.bean.OrderItemBean
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class OrderItemDAO {

    fun insert(orderItemBean: OrderItemBean) {

        var ps: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            Class.forName("com.mysql.jdbc.Driver")
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?characterEncoding=UTF-8", "root", "gakii")
            val sql = "insert into orderitem value (null, ?, ?, ?)"
            ps = connection.prepareStatement(sql)
            ps.setInt(1, orderItemBean.product.id)
            ps.setInt(2, orderItemBean.num)
            ps.setInt(3, orderItemBean.orderBean!!.id)
            ps.execute()

        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            rs?.close()
            ps?.close()
        }
    }
}