package com.xznn.servlet

import com.xznn.dao.ProductDAO
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "ProductListServlet", value = "/listProduct")
class ProductListServlet : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val productList = ProductDAO().getProductList()
        println("productList.size = ${productList.size}")
        req.setAttribute("products", productList)
        req.getRequestDispatcher("listProduct.jsp").forward(req, resp)
    }
}