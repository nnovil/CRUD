/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.model.UserBean;
import com.example.util.DbUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asi
 */
public class UserDao {
     public static boolean isValid(UserBean user) {
        boolean retVar = false;
        DbUtil db = new DbUtil();
        try{
            Connection connection = db.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from users where username=? and password=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                retVar = true;
            }
            rs.close();
            stmt.close();
            db.disconnect();
        }catch(IOException e){
        
        }catch(SQLException e){
        
        }
            return retVar;
    }
     
    public static boolean addUser(UserBean ub){
        boolean retVar = false;
        DbUtil db = new DbUtil();
        try{
            Connection connection = db.getConnection();
            PreparedStatement stmt = connection.prepareStatement("insert into users(username, password) values (?,?) ");
            stmt.setString(1, ub.getUsername());
            stmt.setString(2, ub.getPassword());
            stmt.executeUpdate();
            
            //rs.close();
            stmt.close();
            db.disconnect();
            retVar = true;
        }catch(IOException e){
            retVar = false;
        }catch(SQLException e){
            retVar = false;
        }
        return retVar;
    }
    
    public static boolean deleteUser(UserBean ub){
        boolean retVar = false;
        DbUtil db = new DbUtil();
        try{
            Connection connection = db.getConnection();
            PreparedStatement stmt = connection.prepareStatement("Delete from users where userid=?");
            //stmt.setString(1, ""+ub.getUserid());
            stmt.setInt(1, ub.getUserid());
            //stmt.setString(2, ub.getPassword());
            stmt.executeUpdate();
            //rs.close();
            stmt.close();
            db.disconnect();
            retVar = true;
        }catch(IOException e){
            retVar = false;
        }catch(SQLException e){
            retVar = false;
        }
        return retVar;
    }
    
    public static boolean updateUser(UserBean ub){
        boolean retVar = false;
        DbUtil db = new DbUtil();
        try{
            Connection connection = db.getConnection();
            PreparedStatement stmt = connection.prepareStatement("Update users set username=?, password=? where userid=?");
            stmt.setString(1, ub.getUsername());
            stmt.setString(2, ub.getPassword());
            stmt.setInt(3, ub.getUserid());
            stmt.executeUpdate();
            //rs.close();
            stmt.close();
            db.disconnect();
            retVar = true;
        }catch(IOException e){
            retVar = false;
        }catch(SQLException e){
            retVar = false;
        }
        return retVar;
    }
    
    public static List<UserBean> getAllUsers(){
        List<UserBean> retVar= new ArrayList<>();
        DbUtil db = new DbUtil();
        try{
            Connection connection = db.getConnection();
            PreparedStatement stmt = connection.prepareStatement("select * from users");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                UserBean ub = new UserBean();
                ub.setUserid(rs.getInt("userid"));
                ub.setPassword(rs.getString("password"));
                ub.setUsername(rs.getString("username"));
                retVar.add(ub);
            }
            rs.close();
            stmt.close();
            db.disconnect();
            //retVar = true;
        }catch(IOException e){
            //retVar = false;
        }catch(SQLException e){
            //retVar = false;
        }
        
        return retVar;
    }
    
    public static UserBean getUserById(int id){
        UserBean retVar = null;
        DbUtil db = new DbUtil();
        try{
            Connection connection = db.getConnection();
            PreparedStatement stmt = connection.prepareStatement("Select * from users where userid=?");
            //stmt.setString(1, ""+ub.getUserid());
            stmt.setInt(1, id);
            //stmt.setString(2, ub.getPassword());
            ResultSet rs = stmt.executeQuery(); 
            //while(rs.next()){
            rs.next();
            retVar = new UserBean();
            retVar.setUserid(rs.getInt("userid"));
            retVar.setPassword(rs.getString("password"));
            retVar.setUsername(rs.getString("username"));
            //}
              
            rs.close();
            stmt.close();
            db.disconnect();
            //retVar = true;
        }catch(IOException e){
            //retVar = false;
        }catch(SQLException e){
            //retVar = false;
        }
        return retVar;
    }
    
    public static void main(String[] args){
        //UserBean ub = new UserBean();
        //ub.setUsername("novil");
        //ub.setPassword("novil");
        //System.out.println(UserDao.isValid(ub));
        
        System.out.println(UserDao.getUserById(1));
    }
}
