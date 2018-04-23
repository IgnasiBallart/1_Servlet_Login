package com.MVCWithDAO.dao;

import java.util.List;

public interface DAO<T, K> {

    void insert(T t) throws ExceptionDAO;

    void modify(T t) throws ExceptionDAO;

    void delete(T t) throws ExceptionDAO;

    List<T> listAll() throws ExceptionDAO;

    T get(K id) throws ExceptionDAO;
}
