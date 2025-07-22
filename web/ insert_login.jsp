<%-- 
    Document   :  insert_login
    Created on : 20 Jul, 2025, 8:36:02 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            padding: 40px;
        }
        .container {
            background: #fff;
            padding: 30px;
            max-width: 500px;
            margin: auto;
            box-shadow: 0 0 10px #ccc;
        }
        h2 {
            text-align: center;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-top: 15px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
        }
        button {
            margin-top: 20px;
            padding: 10px;
            width: 100%;
            background: #28a745;
            color: #fff;
            border: none;
        }
        .success {
            text-align: center;
            color: green;
            margin-top: 15px;
        }
        .error {
            text-align: center;
            color: red;
            margin-top: 15px;
        }
    </style>
    </head>
    <body>
        <div class="container">
    <h2>Insert Login Details</h2>
    <form method="post">
        <label>User ID:</label>
        <input type="number" name="user_id" required>

        <label>Login Date:</label>
        <input type="date" name="login_date" required>

        <label>Login Time:</label>
        <input type="time" name="login_time" required>

        <label>Logout Time:</label>
        <input type="time" name="logout_time" required>

        <label>Hours Worked:</label>
        <input type="number" step="0.01" name="hours_worked" required>

        <button type="submit">Submit</button>
    </form>

<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String dbURL = "jdbc:mysql://localhost:3306/hrm_system";
        String dbUser = "root";
        String dbPass = ""; 

        String userId = request.getParameter("user_id");
        String loginDate = request.getParameter("login_date");
        String loginTime = request.getParameter("login_time");
        String logoutTime = request.getParameter("logout_time");
        String hoursWorked = request.getParameter("hours_worked");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String sql = "INSERT INTO logins (user_id, login_date, login_time, logout_time, hours_worked) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(userId));
            ps.setDate(2, Date.valueOf(loginDate));
            ps.setTime(3, Time.valueOf(loginTime + ":00"));
            ps.setTime(4, Time.valueOf(logoutTime + ":00"));
            ps.setBigDecimal(5, new java.math.BigDecimal(hoursWorked));

            int result = ps.executeUpdate();

            if (result > 0) {
%>
                <div class="success">Login data inserted successfully.</div>
<%
            } else {
%>
                <div class="error">Failed to insert login data.</div>
<%
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
%>
            <div class="error">Error: <%= e.getMessage() %></div>
<%
        }
    }
%>
</div>
    </body>
</html>
