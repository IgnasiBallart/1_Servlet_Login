package com.MVCWithDAO.service;

import com.MVCWithDAO.dao.ExceptionDAO;
import com.MVCWithDAO.model.User;

public interface UserService {

    boolean login(String user, String password) throws ExceptionDAO;

    User getUserByUsername(String user) throws ExceptionDAO;

    void insertUser(User u) throws ExceptionDAO;
}
