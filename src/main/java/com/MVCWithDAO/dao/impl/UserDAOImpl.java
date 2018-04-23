package com.MVCWithDAO.dao.impl;

import com.MVCWithDAO.dao.ConnectionFactory;
import com.MVCWithDAO.dao.UserDAO;
import com.MVCWithDAO.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String INSERT = "INSERT INTO users(user, password) VALUES(?, ?)";
    private static final String UPDATE = "UPDATE users set user = ?, set password = ? WHERE id_user = ?";
    private static final String DELETE = "DELETE FROM users WHERE id_user = ?";
    private static final String GETALL = "SELECT id_user, user, password FROM users";
    private static final String GETONE = "SELECT id_user, user, password FROM users WHERE id_user = ?";
    private static final String GETONEbyUSERNAME = "SELECT id_user, user, password FROM users WHERE user = ?";

    private static UserDAO userDAO;

    private ConnectionFactory connFactory;

    private User userStatic;

    public UserDAOImpl() {
        this.connFactory = ConnectionFactory.getInstance();
        this.userStatic = User.getDefaultInstance();
    }

    public static UserDAO getDefaultInstance() {
        if(userDAO==null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    @Override
    public void insert(User u) {
        PreparedStatement stat;
        ResultSet rs;
        try {
            stat = connFactory.getConn().prepareStatement(INSERT);
            stat.setString(1, u.getUser());
            stat.setString(2, u.getPassword());
            stat.executeUpdate();

            rs = stat.getGeneratedKeys();
            if (rs.next()){
                u.setId(rs.getInt(1));
            }else{

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            connFactory.closeConnection();
        }

    }

    @Override
    public void modify(User u) {
        PreparedStatement stat;
        try {
            stat = connFactory.getConn().prepareStatement(UPDATE);
            stat.setString(1, u.getUser());
            stat.setString(2, u.getPassword());
            stat.setInt(3, u.getId());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            connFactory.closeConnection();
        }
    }

    @Override
    public void delete(User u) {
        PreparedStatement stat = null;
        try {
            stat = connFactory.getConn().prepareStatement(DELETE);
            stat.setInt(1, u.getId());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            connFactory.closeConnection();
        }
    }

    private User convert(ResultSet rs) throws SQLException {
        String username = rs.getString("user");
        String password = rs.getString("password");
        userStatic.setUser(username);
        userStatic.setPassword(password);

        return userStatic;
    }

    @Override
    public List<User> listAll() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            stat = connFactory.getConn().prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                users.add(convert(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat != null){
                connFactory.closeConnection();
            }
        }
        return users;
    }

    @Override
    public User get(Integer id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        User u = null;
        try {
            stat = connFactory.getConn().prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                u = convert(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat != null){
                connFactory.closeConnection();
            }
        }
        return u;
    }

    @Override
    public User getUserByUsername(String username){
        PreparedStatement stat = null;
        ResultSet rs = null;
        User u = null;
        try{
            stat = connFactory.getConn().prepareStatement(GETONEbyUSERNAME);
            stat.setString(1, username);
            rs = stat.executeQuery();
            if(rs.next()){
                u = convert(rs);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat != null){
                connFactory.closeConnection();
            }
        }
        return u;
    }
}
