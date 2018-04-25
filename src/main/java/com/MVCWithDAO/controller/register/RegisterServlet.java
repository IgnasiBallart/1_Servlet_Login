package com.MVCWithDAO.controller.register;

import com.MVCWithDAO.entity.User;
import com.MVCWithDAO.service.UserService;
import com.MVCWithDAO.service.impl.MD5Hash;
import com.MVCWithDAO.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
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

        String url = "";
        String errorMessage = "";

        //Pull the fields form the form
        String user = request.getParameter("user");
        String pass = request.getParameter("password");

        try {
            //If inputs are empty
            if (user.trim().equals("") || pass.trim().equals("")) {
                errorMessage = "Both fields must be filled";
                response.sendRedirect("register.jsp");
            //If user does not exist we create it
            } else if (userService.getUserByUsername(user) == null) {
                String passHashed = MD5Hash.hashString(pass);
                userStatic.setUser(user);
                userStatic.setPassword(passHashed);
                userService.insertUser(userStatic);
                url = "login.jsp";
            //User already exists
            } else {
                errorMessage = "Error: User already exists";
                url = "register.jsp";
            }
            //Set the error message
            request.setAttribute("errorMessage", errorMessage);
            //Forward our request
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
