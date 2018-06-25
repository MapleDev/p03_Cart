package com.xznn.servlet

import com.xznn.bean.OrderItemBean
import com.xznn.dao.ProductDAO
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.util.ArrayList


class OrderDeleteServlet : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {

        val pid = req.getParameter("pid").toInt()

        @Suppress("UNCHECKED_CAST")
        var orderItems: MutableList<OrderItemBean>? = req.session.getAttribute("orderItems") as MutableList<OrderItemBean>?
        if (orderItems == null) {
            orderItems = ArrayList<OrderItemBean>()
            req.session.setAttribute("orderItems", orderItems)
        }
        println("orderItems = ${orderItems.size}")

        for (orderItem in orderItems) {
            if (orderItem.id == pid) {
                orderItems.remove(orderItem)
                break
            }
        }

        resp.sendRedirect("listOrderItem.jsp")
    }
}