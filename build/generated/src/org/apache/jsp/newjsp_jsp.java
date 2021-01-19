package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write(" \n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("window.onload = function() { \n");
      out.write(" \n");
      out.write("var dataPoints = [];\n");
      out.write(" \n");
      out.write("var chart = new CanvasJS.Chart(\"chartContainer\", {\n");
      out.write("\tanimationEnabled: true,\n");
      out.write("\texportEnabled: true,\n");
      out.write("\ttitle: {\n");
      out.write("\t\ttext: \"Tuna Production\"\n");
      out.write("\t},\n");
      out.write("\taxisY: {\n");
      out.write("\t\ttitle: \"in metric tons\"\n");
      out.write("\t},\n");
      out.write("\tdata: [{\n");
      out.write("\t\ttype: \"column\",\n");
      out.write("\t\ttoolTipContent: \"{y} metric tons\",\n");
      out.write("\t\tdataPoints: dataPoints\n");
      out.write("\t}]\n");
      out.write("});\n");
      out.write(" \n");
      out.write("$.get(\"https://canvasjs.com/data/gallery/jsp/tuna-production.csv\", getDataPointsFromCSV);\n");
      out.write(" \n");
      out.write("//CSV Format\n");
      out.write("//Year,Volume\n");
      out.write("function getDataPointsFromCSV(csv) {\n");
      out.write("\tvar points;\n");
      out.write("\tvar csvLines = csv.split(/[\\r?\\n|\\r|\\n]+/);\n");
      out.write("\tfor (var i = 1; i < csvLines.length; i++) {\n");
      out.write("\t\tif (csvLines[i].length > 0) {\n");
      out.write("\t\t\tpoints = csvLines[i].split(\",\");\n");
      out.write("\t\t\tdataPoints.push({\n");
      out.write("\t\t\t\tlabel: points[0],\n");
      out.write("\t\t\t\ty: parseFloat(points[1])\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\tchart.render();\n");
      out.write("}\n");
      out.write(" \n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"chartContainer\" style=\"height: 370px; width: 100%;\"></div>\n");
      out.write("<script src=\"https://canvasjs.com/assets/script/jquery-1.11.1.min.js\"></script>\n");
      out.write("<script src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>  ");
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
