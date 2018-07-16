package com.xznn.dao

import com.xznn.bean.OrderBean
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class OrderDAO {

    fun insert(orderBean: OrderBean) {

        var ps: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            Class.forName("com.mysql.jdbc.Driver")
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?characterEncoding=UTF-8", "root", "admin")
            val sql = "insert into order_ value (null, ?)"
            ps = connection.prepareStatement(sql)
            ps.setInt(1, orderBean.user.id)
            ps.execute()
            rs = ps.generatedKeys
            while (rs.next()) {
                val id = rs.getInt(1)
                orderBean.id = id
            }

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