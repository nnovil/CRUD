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
public class UserControllerServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           String action = req.getParameter("action");
           int id = Integer.parseInt(req.getParameter("userid"));
           UserBean ub = UserDao.getUserById(id);
           
           HttpSession session = req.getSession();
           //session.setAttribute("tbeid", id);
           //session.setAttribute("tbeusername", ub.getUsername());
           //session.setAttribute("tbepassword", ub.getPassword());
           session.setAttribute("tbe", ub);
           RequestDispatcher rd;
           
           if(action.equals("delete")){
               UserDao.deleteUser(ub);
               rd = req.getRequestDispatcher("home.jsp");
               rd.forward(req, resp);
               
           }
           else{
                
                rd = req.getRequestDispatcher("user.jsp");
                rd.forward(req, resp);
           }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           String username = req.getParameter("username");
           String password = req.getParameter("password");
           
           HttpSession session = req.getSession();
           //UserBean ub = new UserBean();
           //ub.setUserid(Integer.parseInt((String)req.getAttribute("id")));
           //if(ub.getUserid()==0)
           UserBean ub = (UserBean)session.getAttribute("tbe");
           if(ub.getUserid()==0)
               ub = new UserBean();
           ub.setUsername(username);
           ub.setPassword(password);
           
           if(ub.getUserid() == 0){
               UserDao.addUser(ub);
           }
           else{
               UserDao.updateUser(ub);
           }
           
           RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
           rd.forward(req, resp);
    }
    
    
    
}
