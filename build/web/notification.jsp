<%-- 
    Document   : notification
    Created on : 21 Jul, 2025, 12:54:38 PM
    Author     : hp
--%>

<%@ page import="java.sql.*, java.time.*, java.text.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    
    String dbURL = "jdbc:mysql://localhost:3306/hrm_system";
    String dbUser = "root";
    String dbPass = "Sakshi@2020"; 
    Connection conn = null;
    boolean hasSubmitted = false;

    
    int userId = 1;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        
        LocalDate today = LocalDate.now();
        LocalDate weekStart = today.with(DayOfWeek.MONDAY);

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM availability WHERE user_id = ? AND week_start = ?");
        ps.setInt(1, userId);
        ps.setDate(2, java.sql.Date.valueOf(weekStart));
        ResultSet rs = ps.executeQuery();

        hasSubmitted = rs.next();

        rs.close();
        ps.close();
        conn.close();
    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Availability Notification</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .notification {
            padding: 15px;
            margin: 20px;
            background-color: #f44336;
            color: white;
            font-weight: bold;
            border-radius: 5px;
        }
        .submitted {
            padding: 15px;
            margin: 20px;
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<%
    if (!hasSubmitted) {
%>
    <div class="notification">
        ⚠️ You have not submitted your availability for this week (starting <%= LocalDate.now().with(DayOfWeek.MONDAY) %>). Please submit it now.
    </div>
<%
    } else {
%>
    <div class="submitted">
        ✅ Your availability for this week has already been submitted.
    </div>
<%
    }
%>

</body>
</html>
