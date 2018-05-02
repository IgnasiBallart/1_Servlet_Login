package com.MVCWithDAO.model;

import java.io.Serializable;

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private static User userStatic;

    private int id;

    private String user;

    private String password;

    public User(){
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static User getDefaultInstance() {
        if(userStatic == null) {
            userStatic = new User();
        }
        return userStatic;
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
