package com.xznn.servlet

import com.xznn.dao.UserDAO
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class UserLoginServlet : HttpServlet() {

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        val name = req.getParameter("name")
        val password = req.getParameter("password")

        val user = UserDAO().getUserByName(name, password)

        if (user == null) {
            resp.sendRedirect("login.html")
        } else {
//            req.getRequestDispatcher("listProduct").forward(req, resp)
            req.session.setAttribute("user", user)
            resp.sendRedirect("listProduct")
        }
    }
}