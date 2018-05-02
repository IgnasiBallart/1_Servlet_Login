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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url;
        String errorMessage = "";

        //Pull the fields form the form
        String user = request.getParameter("user");
        String pass = request.getParameter("password");

        try{
            //Encrypt the password
            String passHashed = MD5Hash.hashString(pass);
            //If we found a user that matches the credential
            if (userService.login(user,passHashed)){
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                url = "/menu/home";
            }else{
                errorMessage = "Error: User or password are incorrect";
                url = "/login";
            }
            //Set the error message
            request.setAttribute("errorMessage", errorMessage);
            //Send redirect
            response.sendRedirect(url);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
