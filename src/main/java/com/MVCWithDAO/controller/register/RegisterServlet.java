package com.MVCWithDAO.controller.register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by iballart on 12/04/18.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"}, loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("password");
        if(user == null || pass == null){
            //ERROR!
        }else{
            request.setAttribute("user", user);
            request.setAttribute("password", pass);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
