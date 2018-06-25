package com.xznn.dao

import org.junit.Test


class UserDAOTest {
    @Test
    fun getUserByName() {
        val user = UserDAO().getUserByName("admin", "123")
        println(" user = ${user}")
    }
}
