package com.xznn.bean

data class OrderBean(
        var id: Int,
        var user: UserBean
) {
    constructor(user: UserBean): this(0, user)
}
