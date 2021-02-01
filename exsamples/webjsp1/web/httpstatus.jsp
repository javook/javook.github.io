<%-- 
    Document   : httpstatus
    Created on : Dec 26, 2020, 12:53:53 PM
    Author     : alishz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Loading Page</title>
    </head>
    <body>
        <% response.sendError(440, "Not Loading Page ");%>
</html>
