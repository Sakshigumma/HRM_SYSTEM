<%-- 
    Document   : submit_availability_action
    Created on : 20 Jul, 2025, 7:40:13 PM
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
    int userId = (Integer)session.getAttribute("user_id");
    String dbURL = "jdbc:mysql://localhost:3306/hrm_system";
    String dbUser = "root";
    String dbPass = "Sakshi@2020";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
    boolean mon = request.getParameter("mon") != null;
    boolean tue = request.getParameter("tue") != null;
    boolean wed = request.getParameter("wed") != null;
    boolean thu = request.getParameter("thu") != null;
    String weekStart = request.getParameter("week_start");
    PreparedStatement ps = conn.prepareStatement("INSERT INTO availability (user_id, week_start, mon_available, tue_available, wed_available, thu_available, submitted_at) VALUES (?, ?, ?, ?, ?, ?, NOW())");
    ps.setInt(1, userId);
    ps.setDate(2, java.sql.Date.valueOf(weekStart));
    ps.setBoolean(3, mon);
    ps.setBoolean(4, tue);
    ps.setBoolean(5, wed);
    ps.setBoolean(6, thu);
    ps.executeUpdate();
    conn.close();
    response.sendRedirect("dashboard.jsp");
%>

    </body>
</html>
