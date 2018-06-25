package com.xznn.servlet

import com.xznn.bean.OrderBean
import com.xznn.bean.OrderItemBean
import com.xznn.bean.UserBean
import com.xznn.dao.OrderDAO
import com.xznn.dao.OrderItemDAO
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "OrderCreateServlet", value = ["/createOrder"])
class OrderCreateServlet : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        /**
         * OrderCreateServlet创建订单的Servlet
        1. 首选判断用户是否登陆，如果没有登陆跳转到登陆页面
        2. 创建一个订单对象，并设置其所属用户
        3. 把该订单对象保存到数据库中
        4. 遍历session中所有的订单项，设置他们的Order。 然后保存到数据库中
        5. 清空session中的订单项
        6. 最后打印订单创建成功
         */

        val user = req.session.getAttribute("user")
        if (user == null) {
            resp.sendRedirect("login.html")
            return
        }

        val orderBean = OrderBean(user as UserBean)
        OrderDAO().insert(orderBean)
        @Suppress("UNCHECKED_CAST")
        val orderItems = req.session.getAttribute("orderItems") as MutableList<OrderItemBean>
        orderItems.forEach { it ->
            it.orderBean = orderBean
            OrderItemDAO().insert(it)
        }
        orderItems.clear()

        resp.contentType = "text/html; charset=UTF-8"
        resp.writer.println("订单创建成功")
    }
}