<%-- 
    Document   : dashboard
    Created on : 20 Jul, 2025, 7:34:23 PM
    Author     : hp
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%
    if (session.getAttribute("user_id") == null) {
        response.sendRedirect("loginpage1.html");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Developer Dashboard</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #1f1c2c, #928DAB);
            color: #fff;
        }
        .container {
            max-width: 700px;
            margin: 60px auto;
            background: rgba(255, 255, 255, 0.1);
            padding: 40px;
            border-radius: 16px;
            box-shadow: 0 0 20px rgba(0,0,0,0.3);
            text-align: center;
        }
        h2 {
            margin-bottom: 30px;
            font-size: 28px;
            color: #f9f9f9;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            margin: 15px 0;
        }
        a {
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 12px 24px;
            border-radius: 8px;
            transition: background-color 0.3s ease;
            display: inline-block;
        }
        a:hover {
            background-color: #45a049;
        }
        .logout {
            background-color: #f44336;
        }
        .logout:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome, <%= session.getAttribute("user_name") %>!</h2>
        <ul>
            <li><a href="submit_availability.jsp">🗓️ Submit Weekly Availability</a></li>
            <li><a href="view_logins.jsp">🕒 View Login Records</a></li>
            <li><a href="feedback.jsp">💬 Feedback</a></li>
            <li><a href="notification.jsp">🔔 Notifications</a></li>
            <li><a class="logout" href="logout.jsp">🚪 Logout</a></li>
        </ul>
    </div>
</body>
</html>
