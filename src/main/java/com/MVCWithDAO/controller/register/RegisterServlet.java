package com.MVCWithDAO.controller.register;

import com.MVCWithDAO.entity.User;
import com.MVCWithDAO.service.UserService;
import com.MVCWithDAO.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"}, loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    private User userStatic;

    public RegisterServlet() {
        this.userService = UserServiceImpl.getDefaultInstance();
        this.userStatic = User.getDefaultInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("password");

        if(user == null || pass == null) {
            System.out.println("Both fields must be filled");
        }else if(userService.getUserByUsername(user) == null){
            userStatic.setUser(user);
            userStatic.setPassword(pass);
            userService.insertUser(userStatic);
        }else{
            System.out.println("User already exists");
        }
    }
}
