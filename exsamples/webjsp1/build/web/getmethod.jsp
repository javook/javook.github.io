<%-- 
    Document   : getmethod
    Created on : Dec 26, 2020, 1:19:06 PM
    Author     : alishz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Get Method</title>

    </head>
    <body>
        <h1>Using Get Method For Send Data</h1>
        <br>
        <ul>
            <li><p><b>First Name : </b>
                        <%=request.getParameter("first_name")%>

                </p></li>

            <li><p><b>Last Name : </b>
                        <%=request.getParameter("last_name")%>

                </p></li>
        </ul>
    </body>
</html>
