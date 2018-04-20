package com.MVCWithDAO.entity;

import java.io.Serializable;

/**
 * Created by iballart on 16/04/18.
 */

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;

    private String user;

    private String password;

    public User(){
    }

    public User(int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
