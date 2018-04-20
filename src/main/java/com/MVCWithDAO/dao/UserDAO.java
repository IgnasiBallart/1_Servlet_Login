package com.MVCWithDAO.dao;

import com.MVCWithDAO.entity.User;

import java.util.List;

public interface UserDAO extends DAO<User, Integer> {

    void insert(User u);

    void modify(User u);

    void delete(User u);

    List<User> listAll();

    User get(Integer id);

    User getUserByUsername(String username);

}
