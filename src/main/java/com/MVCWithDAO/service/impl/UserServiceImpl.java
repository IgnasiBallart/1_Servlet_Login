package com.MVCWithDAO.service.impl;

import com.MVCWithDAO.dao.ExceptionDAO;
import com.MVCWithDAO.dao.UserDAO;
import com.MVCWithDAO.dao.impl.UserDAOImpl;
import com.MVCWithDAO.model.User;
import com.MVCWithDAO.service.UserService;

public class UserServiceImpl implements UserService{

    private static UserService userService;

    private UserDAO userDAO;

    private User userStatic;

    public UserServiceImpl() {
        this.userDAO = UserDAOImpl.getDefaultInstance();
        this.userStatic = User.getDefaultInstance();
    }

    public static UserService getDefaultInstance() {
        if(userService==null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public boolean login(String username, String pass) throws ExceptionDAO {
        getUserByUsername(username);
        if (userStatic.getUser().equals(username) && userStatic.getPassword().equals(pass)) {
            return true;
        }
        return false;
    }

    @Override
    public User getUserByUsername(String username) throws ExceptionDAO {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public void insertUser(User u) throws ExceptionDAO {
        userDAO.insert(u);
    }
}
