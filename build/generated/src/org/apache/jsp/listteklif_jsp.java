package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jquery.datatables.model.*;

public final class listteklif_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \n");
      out.write("\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Applying jQuery DataTables plugin in the Java Server application</title>\n");
      out.write("        <link href=\"media/dataTables/demo_page.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"media/dataTables/demo_table.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"media/dataTables/demo_table_jui.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"media/themes/base/jquery-ui.css\" rel=\"stylesheet\" \n");
      out.write("\n");
      out.write("           type=\"text/css\" media=\"all\" />\n");
      out.write("        <link href=\"media/themes/smoothness/jquery-ui-1.7.2.custom.css\" \n");
      out.write("\n");
      out.write("           rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <script src=\"scripts/jquery-1.4.4.min.js\"\n");
      out.write("\n");
      out.write("           type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"scripts/jquery.dataTables.min.js\" \n");
      out.write("\n");
      out.write("           type=\"text/javascript\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        $(document).ready(function () {\n");
      out.write("            $(\"#companies\").dataTable({\n");
      out.write("                \"sPaginationType\": \"full_numbers\",\n");
      out.write("                \"bJQueryUI\": true\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body id=\"dt_example\">\n");
      out.write("        <div id=\"container\">\n");
      out.write("            <div id=\"demo_jui\">\n");
      out.write("                <table id=\"companies\" class=\"display\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Company name</th>\n");
      out.write("                            <th>Address</th>\n");
      out.write("                            <th>Town</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                      ");
 for(Company c: DataRepository.GetCompanies()){ 
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                             <td>");
      out.print(c.getName());
      out.write("</td>\n");
      out.write("                         <td>");
      out.print(c.getAddress());
      out.write("</td>\n");
      out.write("                         <td>");
      out.print(c.getTown());
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("         </div>\n");
      out.write("        </div> \n");
      out.write("    </body>\n");
      out.write("</html>");
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
