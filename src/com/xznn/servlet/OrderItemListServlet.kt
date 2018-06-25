package com.xznn.servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class OrderItemListServlet : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {

//        resp.sendRedirect("listOrderItem.jsp")
        req.getRequestDispatcher("listOrderItem.jsp").forward(req, resp)
    }
}