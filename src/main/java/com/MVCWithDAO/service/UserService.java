package com.MVCWithDAO.service;

import com.MVCWithDAO.entity.User;

public interface UserService {

    boolean login(String user, String password);

    User getUserByUsername(String user);

    void insertUser(User u);
}
