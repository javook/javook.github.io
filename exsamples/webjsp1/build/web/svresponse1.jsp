<%-- 
    Document   : svresponse1
    Created on : Dec 26, 2020, 9:12:24 AM
    Author     : alishz
--%>

<%@page contentType= "text/html" pageEncoding="UTF-8" %>
<%@page import= "java.io.*,java.util.*" %>
<%@page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auto Refresh Page</title>
    </head>
    <body>
        <h1></h1>
        <%! String CT;%>
        <% response.setIntHeader("Refresh", 10);

            Calendar calendar = new GregorianCalendar();

            String am_pm;
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            int seconds = calendar.get(Calendar.SECOND);

            if (calendar.get(Calendar.AM_PM) == 0) {

                am_pm = "AM";
                CT = hour + ": " + minute + ": " + seconds;
                out.print("Current Time Is    " + CT);%></br></br>
        <%
        } else {
            am_pm = "PM";
            CT = hour + ": " + minute + ": " + seconds;
            out.print("Current Time Is : " + CT);%></br></br>
        <%   }%>


    </body>
</html>
