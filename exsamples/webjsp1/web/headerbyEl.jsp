<%-- 
    Document   : headerbyEl
    Created on : Dec 26, 2020, 10:51:59 AM
    Author     : alishz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.*" %>

<%!String title = "User Agent";%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=title%></title>
    </head>
    <body>


    <Center><h1><%="User Agent "%></h1></Center>

    <div align="center"><p>${header["user-agent"]}</p></div>

</body>
</html>
