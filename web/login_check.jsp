<%-- 
    Document   : login_check
    Created on : 20 Jul, 2025, 7:11:15 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.sql.*" %>
<%
   

    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String dbURL = "jdbc:mysql://localhost:3306/hrm_system";
    String dbUser = "root";
    String dbPass = "Sakshi@2020";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
    stmt.setString(1, email);
    stmt.setString(2, password);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
        session.setAttribute("user_id", rs.getInt("id"));
        session.setAttribute("user_name", rs.getString("name"));
        response.sendRedirect("dashboard.jsp");
    } else {
        out.println("Login failed. <a href='index.html'>Try again</a>");
    }
    conn.close();
%>
    </body>
</html>
