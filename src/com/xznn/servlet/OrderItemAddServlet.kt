package com.xznn.servlet

import com.xznn.bean.OrderItemBean
import com.xznn.dao.ProductDAO
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.util.ArrayList


class OrderItemAddServlet : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        /**
         * 购买行为本身就是创建一个OrderItem对象
        在负责购买商品的OrderItemAddServlet 中，进行如下流程
        1. 获取购买数量
        2. 获取购买商品的id
        3. 根据id获取商品对象
        4. 创建一个新的OrderItem对象
        5. 从session中取出一个List , 这个List里面存放陆续购买的商品。
        如果是第一次从session中获取该List,那么它会是空的，需要创建一个ArrayList
        6. 把新创建的OrderItem对象放入该List种
        7. 跳转到显示购物车的listOrderItem
         */

        val pid = req.getParameter("pid").toInt()
        val num = req.getParameter("num").toInt()

        val productBean = ProductDAO().getUserById(pid)
        if (productBean == null) {
            println("productBean == null")
            return
        }
        println("pid = $pid, num = $num, productBean = $productBean")

        @Suppress("UNCHECKED_CAST")
        var orderItems: MutableList<OrderItemBean>? = req.session.getAttribute("orderItems") as MutableList<OrderItemBean>?
        if (orderItems == null) {
            orderItems = ArrayList<OrderItemBean>()
            req.session.setAttribute("orderItems", orderItems)
        }
        println("orderItems = ${orderItems.size}")

        var isExist = false
        for (orderItem in orderItems) {
            if (orderItem.id == pid) {
                orderItem.num += num
                isExist = true
                break
            }
        }

        if (!isExist) {
            val orderItemBean = OrderItemBean(productBean, num)
            orderItems.add(orderItemBean)
        }
        resp.sendRedirect("listOrderItem.jsp")
    }
}