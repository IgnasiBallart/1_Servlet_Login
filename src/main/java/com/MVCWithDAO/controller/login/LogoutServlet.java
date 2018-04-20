package com.MVCWithDAO.controller.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by iballart on 13/04/18.
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"}, loadOnStartup = 1)
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}