package com.MVCWithDAO.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by iballart on 13/04/18.
 */
public class ConnectionFactory {
    private static ConnectionFactory ourInstance;
    private Connection conn;

    private ConnectionFactory() {
        try{
            if(conn == null){
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/1_Servlet_Login","root", "root");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized static ConnectionFactory getInstance() {
        if(ourInstance == null){
            ourInstance = new ConnectionFactory();
        }
        return ourInstance;
    }

    public Connection getConn(){
        return conn;
    }

    public void closeConnection(){
        ourInstance = null;
    }
}
