/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.53
 * Generated at: 2018-08-23 09:41:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Edit Book</title>\r\n");
      out.write("<style>\r\n");
      out.write("\ta:HOVER{\r\n");
      out.write("\t\tcolor:olive;\r\n");
      out.write("\t}\r\n");
      out.write("\tform {\r\n");
      out.write("   \t \tborder: 3px;\r\n");
      out.write("   \t \tmargin-top: 1.5%;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tinput[type=text]{\r\n");
      out.write("    \twidth: 100%;\r\n");
      out.write("    \tpadding: 12px 20px;\r\n");
      out.write("    \tmargin: 8px 0;\r\n");
      out.write("    \tdisplay: inline-block;\r\n");
      out.write("    \tborder: 1px solid #ccc;\r\n");
      out.write("   \t\tbox-sizing: border-box;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tbody{\r\n");
      out.write("\t\tfont-family: Verdana;\r\n");
      out.write("\t\tbackground-color: lightblue;\r\n");
      out.write("\t}\r\n");
      out.write("\th1{\r\n");
      out.write("\tcolor:red;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\ttable{\r\n");
      out.write("\t\theight: 40px;\r\n");
      out.write("\t\twidth: 40px;\r\n");
      out.write("\t}\r\n");
      out.write("\tfooter{\r\n");
      out.write("\t\tmargin-bottom: 0px;\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("    left: 0;\r\n");
      out.write("    bottom: 0;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    color: white;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\th3{\r\n");
      out.write("\t\tcolor: red;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv ul {\r\n");
      out.write("    list-style-type: none;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    margin-bottom: 50px;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height : 50px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\tli {\r\n");
      out.write("    float:left;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\th1{\r\n");
      out.write("\t\tclear: both;\r\n");
      out.write("\t}\r\n");
      out.write("a {\r\n");
      out.write("    display: block;\r\n");
      out.write("    padding: 8px;\r\n");
      out.write("    \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" <div>\r\n");
      out.write("\t<ul>\r\n");
      out.write("  <li><a href=\"librarian.jsp\">Home</a></li>\r\n");
      out.write("  <li><a href=\"libhistory\">Get History</a></li>\r\n");
      out.write("  <li><a href=\"librarianServlet\">Get All Books</a></li>\r\n");
      out.write("  <li><a href=\"add\">Add a book</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<header>\r\n");
      out.write("\t  <h1>Enter the details of book to edit</h1>\r\n");
      out.write("  </header>\r\n");
      out.write("<div style=\"text-align:left\" ><a href=\"librarian.jsp\" style=\"font-size: 30px;text-decoration: none;\">Back</a></div>\r\n");
      out.write("\r\n");
      out.write("\t<form  method=\"POST\" action=\"edit\">\r\n");
      out.write("\t\tEnter id<input type=\"text\" name=\"bid\" readonly value=\"");
      out.print(session.getAttribute("id"));
      out.write("\" ><br>\r\n");
      out.write("\t\tEnter title<input type=\"text\" name=\"title\" value=\"");
      out.print(session.getAttribute("title"));
      out.write("\"><br>\r\n");
      out.write("\t\tEnter author<input type=\"text\" name=\"author\" value=\"");
      out.print(session.getAttribute("author"));
      out.write("\"><br>\r\n");
      out.write("\t\tEnter publisher<input type=\"text\" name=\"publisher\" value=\"");
      out.print(session.getAttribute("publisher"));
      out.write("\"><br>\r\n");
      out.write("\t\tEnter copies<input type=\"text\" name=\"copies\" value=\"");
      out.print(session.getAttribute("copies"));
      out.write("\"><br>\r\n");
      out.write("\t\t<table align=\"center\">\r\n");
      out.write("\t\t<tr><td ><input type=\"submit\" value=\"edit\" ></td></tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t\t<img src=\"images/footer_kids3.jpg\"></img>\r\n");
      out.write("\t\t<h3>Optum Library <sup>&reg;</sup></h3>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
