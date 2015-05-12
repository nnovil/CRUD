/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import com.example.model.UserBean;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author asi
 */
public class DbUtil {
    private Connection connection = null;
    
    public Connection getConnection() throws IOException{
        if(connection!=null)
            return connection;
        else{
            try{
                String driver="com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/users";
                Class.forName(driver);
                //Properties prop = new Properties();
                //InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
                //prop.load(is);
                
                //String driver = prop.getProperty("driver");
                //String url = prop.getProperty("url");
                //String user = prop.getProperty("user");
                //String pass = prop.getProperty("password");
                //Class.forName(driver);
                
                connection = (Connection)DriverManager.getConnection(url, "root", "alliance");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
        
        }
        return connection;
    }
    
   
    
    
    public void disconnect(){
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
