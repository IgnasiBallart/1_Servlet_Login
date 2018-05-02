package com.MVCWithDAO.dao;

import com.MVCWithDAO.model.User;

import java.util.List;

public interface UserDAO extends DAO<User, Integer> {

    void insert(User u) throws ExceptionDAO;

    void modify(User u) throws ExceptionDAO;

    void delete(User u) throws ExceptionDAO;

    List<User> listAll() throws ExceptionDAO;

    User get(Integer id) throws ExceptionDAO;

    User getUserByUsername(String username) throws ExceptionDAO;

}
