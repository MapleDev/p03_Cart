package com.xznn.dao

import com.xznn.bean.UserBean
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class UserDAO {

    fun getUserByName(name: String, password: String): UserBean? {

        var user: UserBean? = null

        var ps: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            Class.forName("com.mysql.jdbc.Driver")
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart?characterEncoding=UTF-8", "root", "gakii")
//            val sql = "select * from user where name = ? and password = ?"
            val sql = "select * from user where name = ?"
            ps = connection.prepareStatement(sql)
            ps.setString(1, name)
            rs = ps.executeQuery()
            var isExist = false
            while (rs.next()) {
                isExist = true
                val id = rs.getInt("id")
                val passwordRst = rs.getString("password")
                if (password == passwordRst) {
                    user = UserBean(id, name, password)
                } else {
                    println("密码有误")
                }
                break
            }
            if (!isExist) {
                println("账号不存在")
            }

        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            rs?.close()
            ps?.close()
        }

        return user
    }
}