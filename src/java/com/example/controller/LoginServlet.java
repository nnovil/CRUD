/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.UserBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asi
 */
public class LoginServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        RequestDispatcher rd;
        
        HttpSession session = req.getSession();
        
        UserBean um = new UserBean();
        
        um.setUsername(username);
        um.setPassword(password);
        
        boolean tempVar = UserDao.isValid(um);
        List<UserBean> ub = UserDao.getAllUsers();
        session.setAttribute("users", ub);
        session.setAttribute("username", um.getUsername());
        System.out.println("Found "+tempVar);
        
        if(tempVar){
            rd = req.getRequestDispatcher("home.jsp");
            rd.forward(req, resp);
            System.out.println("Forward "+tempVar);
        }
        else{
            rd = req.getRequestDispatcher("index.html");
            rd.forward(req, resp);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
}
