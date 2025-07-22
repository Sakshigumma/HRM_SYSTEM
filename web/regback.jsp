<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Processing</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String role = request.getParameter("role");

    Connection conn = null;
    PreparedStatement pst = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm_system", "root", "Sakshi@2020");

        String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, password);
        pst.setString(4, role);

        int rows = pst.executeUpdate();

        if (rows > 0) {
%>
            <script>
                alert("Registration Successful!");
                window.location.href = "loginpage1.html";
            </script>
<%
        } else {
%>
            <script>
                alert("Registration Failed. Please try again.");
                history.back();
            </script>
<%
        }
    } catch (Exception e) {
%>
        <p>Error: <%= e.getMessage() %></p>
<%
    } finally {
        if (pst != null) pst.close();
        if (conn != null) conn.close();
    }
%>
</body>
</html>
