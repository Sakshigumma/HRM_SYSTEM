/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/registor"})
public class registor extends HttpServlet {

 private static final String DB_URL = "jdbc:mysql://localhost:3306/hrm_system";  
private static final String DB_USER = "root";
private static final String DB_PASSWORD = "Sakshi@2020"; // ← Change this

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    // Set request encoding and response type
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html");

    // Read form parameters
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String role = request.getParameter("role");

    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to database
        conn = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        // SQL query with PreparedStatement
        String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, password); // You may hash password in production
        stmt.setString(4, role);

        // Execute insert
        int result = stmt.executeUpdate();

        if (result > 0) {
            // Redirect to login page on success
            response.sendRedirect("login.html");
        } else {
            response.getWriter().println("Registration failed. Please try again.");
        }

    } catch (IOException | ClassNotFoundException e) {
        response.getWriter().println("Error: " + e.getMessage());
    }   catch (SQLException ex) {
            Logger.getLogger(registor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        // Clean up
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(registor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (conn != null) conn.close();
    }
}

                   }
    

   