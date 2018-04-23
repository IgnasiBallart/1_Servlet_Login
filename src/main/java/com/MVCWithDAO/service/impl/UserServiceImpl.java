package com.MVCWithDAO.service.impl;

import com.MVCWithDAO.dao.UserDAO;
import com.MVCWithDAO.dao.impl.UserDAOImpl;
import com.MVCWithDAO.entity.User;
import com.MVCWithDAO.service.UserService;

public class UserServiceImpl implements UserService{

    private static UserService userService;

    private UserDAO userDAO;

    public UserServiceImpl() {
        this.userDAO = UserDAOImpl.getDefaultInstance();
    }

    public static UserService getDefaultInstance() {
        if(userService==null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public boolean login(String username, String pass) {
        if (getUserByUsername(username) == null) {
            return false;
        }
        return true;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public void insertUser(User u) {
        userDAO.insert(u);
    }
}
