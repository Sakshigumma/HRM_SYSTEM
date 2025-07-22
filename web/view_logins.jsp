<%-- 
    Document   : view_logins
    Created on : 20 Jul, 2025, 8:11:08 PM
    Author     : hp
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
             body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 30px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            background-color: #fff;
        }
        th, td {
            padding: 12px 18px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .back {
            margin-top: 20px;
            text-align: center;
        }
        .back a {
            text-decoration: none;
            color: #007BFF;
            font-weight: bold;
        }
        </style>
    </head>
    <body>
        <h2>User Login Records</h2>

<%
    String dbURL = "jdbc:mysql://localhost:3306/hrm_system";
    String dbUser = "root";
    String dbPass = "Sakshi@2020";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        String sql = "SELECT l.id, u.name, u.email, l.login_date, l.login_time, l.logout_time, l.hours_worked " +
                     "FROM logins l INNER JOIN users u ON l.user_id = u.id ORDER BY l.login_date DESC";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
%>

<table>
    <tr>
        <th>ID</th>
        <th>User Name</th>
        <th>Email</th>
        <th>Login Date</th>
        <th>Login Time</th>
        <th>Logout Time</th>
        <th>Hours Worked</th>
    </tr>

<%
        while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getString("email") %></td>
        <td><%= rs.getDate("login_date") %></td>
        <td><%= rs.getTime("login_time") %></td>
        <td><%= rs.getTime("logout_time") %></td>
        <td><%= rs.getBigDecimal("hours_worked") %></td>
    </tr>
<%
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        out.println("<p style='color:red; text-align:center;'>Error: " + e.getMessage() + "</p>");
        e.printStackTrace();
    }
%>
</table>

<div class="back">
    <p><a href="dashboard.jsp">← Back to Dashboard</a></p>
</div>
    </body>
</html>
