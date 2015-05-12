<%-- 
    Document   : profile.jsp
    Created on : 05 6, 15, 4:14:00 PM
    Author     : asi
--%>

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
        <title>Profile</title>
    </head>
    <body>
     
        <a href="home.jsp" value="home">Home</a> | 
        <a href="profile.jsp" value="profile">Profile</a> | 
        <a href="index.html" value="logout">Logout</a>
        <h2>
            Profile Hello <%=session.getAttribute("username")%>!!!!!!
        </h2>
    </body>
</html>
<%}else{
        response.sendRedirect("index.html");
    }%>