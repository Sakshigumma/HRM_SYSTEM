package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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

    if (session.getAttribute("user_id") == null) {
        response.sendRedirect("loginpage1.html");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Developer Dashboard</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            margin: 0;\n");
      out.write("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("            background: linear-gradient(135deg, #1f1c2c, #928DAB);\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            max-width: 700px;\n");
      out.write("            margin: 60px auto;\n");
      out.write("            background: rgba(255, 255, 255, 0.1);\n");
      out.write("            padding: 40px;\n");
      out.write("            border-radius: 16px;\n");
      out.write("            box-shadow: 0 0 20px rgba(0,0,0,0.3);\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            margin-bottom: 30px;\n");
      out.write("            font-size: 28px;\n");
      out.write("            color: #f9f9f9;\n");
      out.write("        }\n");
      out.write("        ul {\n");
      out.write("            list-style: none;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        li {\n");
      out.write("            margin: 15px 0;\n");
      out.write("        }\n");
      out.write("        a {\n");
      out.write("            text-decoration: none;\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            padding: 12px 24px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("            display: inline-block;\n");
      out.write("        }\n");
      out.write("        a:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("        .logout {\n");
      out.write("            background-color: #f44336;\n");
      out.write("        }\n");
      out.write("        .logout:hover {\n");
      out.write("            background-color: #e53935;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Welcome, ");
      out.print( session.getAttribute("user_name") );
      out.write("!</h2>\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"submit_availability.jsp\">🗓️ Submit Weekly Availability</a></li>\n");
      out.write("            <li><a href=\"view_logins.jsp\">🕒 View Login Records</a></li>\n");
      out.write("            <li><a href=\"feedback.jsp\">💬 Feedback</a></li>\n");
      out.write("            <li><a href=\"notification.jsp\">🔔 Notifications</a></li>\n");
      out.write("            <li><a class=\"logout\" href=\"logout.jsp\">🚪 Logout</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
