<%-- 
    Document   : login
    Created on : 18 Jul, 2025, 12:50:38 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <%@ page import="java.sql.*" %>
        <%@ page import="java.sql.Connection"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
String email = request.getParameter("email");
String password = request.getParameter("password");
String dbURL = "jdbc:mysql://localhost:3306/hrm_system";
String dbUser = "root";
String dbPass = "Sakshi@2020";

boolean validUser = false;
String userName = "";

try {
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

   
    String sql = "SELECT name FROM users WHERE email=? AND password=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, email);
    ps.setString(2, password);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        validUser = true;
        userName = rs.getString("name");
    }

    rs.close();
    ps.close();
    conn.close();
} catch (Exception e) {
    out.println("<p>Error: " + e.getMessage() + "</p>");
}

if (validUser) {
    session.setAttribute("userName", userName);
    response.sendRedirect("dashboard.jsp");
} else {
%>
<script>
alert("Invalid email or password!");
window.location.href = "login.html";
</script>
<%
}
%>

    

