package com.MVCWithDAO.controller.login;

import com.MVCWithDAO.service.UserService;
import com.MVCWithDAO.service.impl.MD5Hash;
import com.MVCWithDAO.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet{

    private UserService userService;

    public LoginServlet() {
        this.userService = UserServiceImpl.getDefaultInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("password");

        try{
            String passHashed = MD5Hash.hashString(pass);
            if (userService.login(user,passHashed)){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("login.jsp");
            }else{
                response.sendRedirect("index.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
