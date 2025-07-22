package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public final class feedback_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

String dbURL = "jdbc:mysql://localhost:3306/hrm_system";
String dbUser = "root";
String dbPass = "Sakshi@2020"; 
Connection conn = null;

int userId = 1; 

double plannedHours = 0.0;
double actualHours = 0.0;
String feedbackMsg = "";
String feedbackClass = "";

try {
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(dbURL, dbUser, dbPass);


PreparedStatement ps1 = conn.prepareStatement("SELECT week_start, mon_available, tue_available, wed_available, thu_available FROM availability WHERE user_id = ? ORDER BY week_start DESC LIMIT 1");
ps1.setInt(1, userId);
ResultSet rs1 = ps1.executeQuery();

java.sql.Date weekStart = null;
boolean mon = false, tue = false, wed = false, thu = false;

if (rs1.next()) {
    weekStart = rs1.getDate("week_start");
    mon = rs1.getBoolean("mon_available");
    tue = rs1.getBoolean("tue_available");
    wed = rs1.getBoolean("wed_available");
    thu = rs1.getBoolean("thu_available");
}

plannedHours = (mon ? 9 : 0) + (tue ? 9 : 0) + (wed ? 9 : 0) + (thu ? 9 : 0);

java.sql.Date startDate = null;
java.sql.Date endDate = null;

if (weekStart != null) {
    startDate = weekStart;
    Calendar cal = Calendar.getInstance();
    cal.setTime(weekStart);
    cal.add(Calendar.DATE, 6);
    endDate = new java.sql.Date(cal.getTimeInMillis());
}

if (startDate != null && endDate != null) {
    PreparedStatement ps2 = conn.prepareStatement(
        "SELECT SUM(hours_worked) AS total_hours FROM logins WHERE user_id = ? AND login_date BETWEEN ? AND ?"
    );
    ps2.setInt(1, userId);
    ps2.setDate(2, startDate);
    ps2.setDate(3, endDate);
    ResultSet rs2 = ps2.executeQuery();
    if (rs2.next()) {
        actualHours = rs2.getDouble("total_hours");
    }
}

if (actualHours >= plannedHours) {
    feedbackMsg = "Great job! You met or exceeded your planned availability.";
    feedbackClass = "green";
} else if (actualHours >= (plannedHours * 0.75)) {
    feedbackMsg = "Good effort! Try to match your planned hours more closely.";
    feedbackClass = "blue";
} else {
    feedbackMsg = "You were below your planned hours. Please ensure consistent availability.";
    feedbackClass = "red";
}
} catch (Exception e) {
e.printStackTrace();
} finally {
if (conn != null) {
try { conn.close(); } catch (Exception ex) { }
}
}

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html> <html> <head> <title>Feedback</title> <style> body { font-family: Arial; margin: 20px; } .green { color: green; } .blue { color: blue; } .red { color: red; } .box { border: 1px solid #ccc; padding: 15px; border-radius: 5px; max-width: 600px; } </style> </head> <body> <h2>Performance Feedback</h2> <div class=\"box\"> <p><strong>Planned Hours:</strong> ");
      out.print( plannedHours );
      out.write(" hrs</p> <p><strong>Actual Worked Hours:</strong> ");
      out.print( actualHours );
      out.write(" hrs</p> <p class=\"");
      out.print( feedbackClass );
      out.write("\"><strong>Feedback:</strong> ");
      out.print( feedbackMsg );
      out.write("</p> </div> </body> </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
