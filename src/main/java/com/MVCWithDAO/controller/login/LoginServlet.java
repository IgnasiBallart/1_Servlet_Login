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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("password");

        try{
            String passHashed = MD5Hash.hashString(pass);
            if (userService.login(user,passHashed)){
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("logged.jsp");
            }else{
                resp.sendRedirect("login.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
