<%-- 
    Document   : home
    Created on : 05 6, 15, 3:55:16 PM
    Author     : asi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control","no-store, must revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", -1);
    
    if(session.getAttribute("username")!=null){
        System.out.println("home");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <a href="home.jsp" value="home">Home</a> | 
        <a href="profile.jsp" value="profile">Profile</a> |
        <a href="index.html" value="logout">Logout</a>
        <h2>
            Home Hello <%=session.getAttribute("username")%>!!!!!!
        </h2>
        <h5>
            <a href="usercontroller?action=add&userid=0">Add a user</a>
        </h5>
        <form method="GET" action="usercontrollerservlet">
        <table border="1">
            <thead>
            <th>Username</th>
            <th>Password</th>
            <th colspan="2">Action</th>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.password}"/></td>
                    <td><a href="usercontroller?action=edit&userid=<c:out value="${user.userid}"/>">Edit</a></td>
                    <td><a href="usercontroller?action=delete&userid=<c:out value="${user.userid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </form>
    </body>
</html>
<%}else{
        response.sendRedirect("index.html");
    }%>