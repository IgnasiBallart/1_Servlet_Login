package com.MVCWithDAO.dao;

import java.util.List;

/**
 * Created by iballart on 16/04/18.
 */
public interface DAO<T, K> {

    void insert(T t);

    void modify(T t);

    void delete(T t);

    List<T> listAll();

    T get(K id);
}
