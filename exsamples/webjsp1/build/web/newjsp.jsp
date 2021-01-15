<%-- 
    Document   : newjsp
    Created on : Dec 19, 2020, 12:58:42 PM
    Author     : alishz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.io.*,java.util.*,java.sql.*"%>
<%@page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- <%String s="ali";%> 
        <%=s%>--%>
        <h1>Information</h1>
        <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/clients" user="root" password="e2ad48t9"/>
        <sql:query var="dbsq" dataSource="${db}">
            Select * From clients.user;
        </sql:query>
            <c:forEach var="data"  items="${dbsq.rows}" >
                <c:out value="${data.id}"/>_
                <c:out value="${data.name}"/>_
                <c:out value="${data.family}"/>_
                <c:out value="${data.tel}"/> </br></br>      
            </c:forEach>    
        
        
        
        
    </body>
</html>
