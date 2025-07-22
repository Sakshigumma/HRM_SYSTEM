package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class submit_005favailability_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        response.sendRedirect("index.html");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Submit Availability</title>\n");
      out.write("    <style>\n");
      out.write("       body {\n");
      out.write("            background-image: url('dash.jpg');\n");
      out.write("            background-size: cover;\n");
      out.write("            background-position: center;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        .wrapper {\n");
      out.write("            max-width: 700px;\n");
      out.write("            margin: 50px auto;\n");
      out.write("            background: #080808c8;\n");
      out.write("            padding: 25px 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.529);\n");
      out.write("            border: 2px solid rgb(6, 6, 6);\n");
      out.write("        }\n");
      out.write("        h2, h3 {\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            color: #fdfdfd;\n");
      out.write("        }\n");
      out.write("        label {\n");
      out.write("            display: block;\n");
      out.write("            margin-top: 12px;\n");
      out.write("            font-weight: 500;\n");
      out.write("            color: #fefefe;\n");
      out.write("        }\n");
      out.write("        input[type=\"date\"],\n");
      out.write("        input[type=\"time\"],\n");
      out.write("        button {\n");
      out.write("            width: 45%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-top: 6px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            font-size: 15px;\n");
      out.write("        }\n");
      out.write("        .checkbox-group {\n");
      out.write("            margin-top: 10px;\n");
      out.write("            display: flex;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            gap: 10px;\n");
      out.write("        }\n");
      out.write("        .checkbox-group label {\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            gap: 6px;\n");
      out.write("            font-weight: normal;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        button {\n");
      out.write("            margin-top: 20px;\n");
      out.write("            background-color: #3498db;\n");
      out.write("            color: #fff;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            width: 200px;\n");
      out.write("            box-shadow: 5px 5px 5px rgb(59, 0, 251);\n");
      out.write("        }\n");
      out.write("        button:hover {\n");
      out.write("            background-color: #2980b9;\n");
      out.write("        }\n");
      out.write("        hr {\n");
      out.write("            margin: 40px 0 30px;\n");
      out.write("            border: 0;\n");
      out.write("            border-top: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"wrapper\">\n");
      out.write("        <h2 style=\"text-align: center;\">Weekly Availability Form</h2>\n");
      out.write("        <form action=\"submit_availability_action.jsp\" method=\"post\">\n");
      out.write("            <label for=\"week_start\">Week Start Date:</label>\n");
      out.write("            <input type=\"date\" name=\"week_start\" id=\"week_start\" required>\n");
      out.write("\n");
      out.write("            <h3 style=\"color: white;\">Select Days You're Available:</h3>\n");
      out.write("            <div class=\"checkbox-group\">\n");
      out.write("                <label><input type=\"checkbox\" name=\"mon\"> Monday</label>\n");
      out.write("                <label><input type=\"checkbox\" name=\"tue\"> Tuesday</label>\n");
      out.write("                <label><input type=\"checkbox\" name=\"wed\"> Wednesday</label>\n");
      out.write("                <label><input type=\"checkbox\" name=\"thu\"> Thursday</label>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <button type=\"submit\">Save Availability</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <hr>\n");
      out.write("\n");
      out.write("        <h2>Log Your Working Hours</h2>\n");
      out.write("        <form action=\"LogTimeServlet\" method=\"post\">\n");
      out.write("            <label for=\"loginDate\">Date:</label>\n");
      out.write("            <input type=\"date\" name=\"loginDate\" id=\"loginDate\" required>\n");
      out.write("\n");
      out.write("            <label for=\"loginTime\">Login Time:</label>\n");
      out.write("            <input type=\"time\" name=\"loginTime\" id=\"loginTime\" required>\n");
      out.write("\n");
      out.write("            <label for=\"logoutTime\">Logout Time:</label>\n");
      out.write("            <input type=\"time\" name=\"logoutTime\" id=\"logoutTime\" required>\n");
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <button type=\"submit\">Log Hours</button>\n");
      out.write("        </form>\n");
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
