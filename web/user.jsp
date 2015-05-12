<%-- 
    Document   : user
    Created on : 05 8, 15, 3:56:49 PM
    Author     : asi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control","no-store, must revalidate");
    response.setHeader("pragma", "no-cache");
    response.setDateHeader("Expires", -1);
    
    if(session.getAttribute("username")!=null){
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <form method="POST" action="usercontroller">
            <a href="home.jsp" value="home">Home</a> | 
            <a href="profile.jsp" value="profile">Profile</a> |
            <a href="index.html" value="logout">Logout</a>
            <h2>
            User Hello <%=session.getAttribute("username")%>!!!!!!
            </h2>
            
            Username <input type="text" name="username" value = <%=session.getAttribute("tbeusername")%>><br>
            Password <input type="password" name ="password" value= <%=session.getAttribute("tbepassword")%>><br>
            <input type="submit" value = "Submit">
        </form>
        
    </body>
</html>
<%}else{
        response.sendRedirect("index.html");
    }%>
