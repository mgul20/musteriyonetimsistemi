package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                                    <!-- navbar-->\n");
      out.write("                                                                         <header class=\"header\">\n");
      out.write("                                        <nav class=\"navbar navbar-expand-lg px-4 py-2 bg-white shadow\"><a href=\"#\" class=\"sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead\"><i class=\"fas fa-align-left\"></i></a><a href=\"");
      out.print(request.getContextPath());
      out.write("/home\" class=\"navbar-brand \">Müsteri Yönetim</a>\n");
      out.write("                                        </nav>\n");
      out.write("                                    </header>\n");
      out.write("                                <div class=\"d-flex align-items-stretch\">\n");
      out.write("                                    <div id=\"sidebar\" class=\"sidebar py-3\">\n");
      out.write("                                        <ul>\n");
      out.write("                                                <li><a> Ho?geldin:");
      out.print(session.getAttribute("tamadi"));
      out.write("</a></li>\n");
      out.write("                                                <li><a> Yetki:");
      out.print(session.getAttribute("turu"));
      out.write("</a></li>\n");
      out.write("                                        </ul>                                        \n");
      out.write("                                        <div class=\"text-gray-400 px-3 px-lg-4 py-4 font-weight-bold small headings-font-family\">Menü</div>\n");
      out.write("                                        <ul class=\"sidebar-menu list-unstyled\">\n");
      out.write("                                            <c:set var=\"yetki\" scope=\"session\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${yetki}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                            <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/home\" class=\"sidebar-link text-muted active\"><i class=\"o-home-1 mr-3 text-gray\"></i><span>Ana Sayfa</span></a></li>\n");
      out.write("                                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${yetki==\"Admin\" || yetki==\"User\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" > \n");
      out.write("                                            <li class=\"sidebar-list-item\"><a href=\"#\" data-toggle=\"collapse\" data-target=\"#pages\" aria-expanded=\"false\" aria-controls=\"pagess\" class=\"sidebar-link text-muted\"><i class=\"o-user-1 mr-3 text-gray\"></i><span>Müsteri</span></a>\n");
      out.write("                                                <div id=\"pages\" class=\"collapse\">\n");
      out.write("                                                    <ul class=\"sidebar-menu list-unstyled border-left border-primary border-thick\">\n");
      out.write("                                                       <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/newmus\" class=\"sidebar-link text-muted pl-lg-5\">Müsteri Kay?t</a></li>\n");
      out.write("                                                        <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/listmus\" class=\"sidebar-link text-muted pl-lg-5\">Müsteri Listesi</a></li>\n");
      out.write("                                                    </ul>\n");
      out.write("                                                </div>\n");
      out.write("                                            </li>\n");
      out.write("                                            </c:if>\n");
      out.write("\n");
      out.write("                                            <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/istektalep\" class=\"sidebar-link text-muted\"><i class=\"o-imac-screen-1 mr-3 text-gray\"></i><span>?stek-Talep ??lemleri</span></a></li>\n");
      out.write("\n");
      out.write("                                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${yetki==\"Admin\" || yetki==\"User\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" > \n");
      out.write("                                            <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/listkontak\" class=\"sidebar-link text-muted\"><i class=\"o-sales-up-1 mr-3 text-gray\"></i><span>Kontak ??lemleri</span></a></li>\n");
      out.write("                                            </c:if>\n");
      out.write("                                            \n");
      out.write("                                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${yetki==\"Admin\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" > \n");
      out.write("                                            <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/listteklif\" class=\"sidebar-link text-muted\"><i class=\"o-table-content-1 mr-3 text-gray\"></i><span>Teklif ??lemleri</span></a></li>\n");
      out.write("                                            </c:if>\n");
      out.write("                                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${yetki==\"User\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" >  \n");
      out.write("                                            <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/home\" class=\"sidebar-link text-muted\"><i class=\"o-table-content-1 mr-3 text-gray\"></i><span>Teklif ??lemleri</span></a></li>\n");
      out.write("                                            </c:if>\n");
      out.write("                                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${yetki==\"Admin\" || yetki==\"User\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" >\n");
      out.write("                                            <li class=\"sidebar-list-item\"><a href=\"#\" data-toggle=\"collapse\" data-target=\"#pages\" aria-expanded=\"false\" aria-controls=\"pages\" class=\"sidebar-link text-muted\"><i class=\"o-user-1 mr-3 text-gray\"></i><span>Kullan?c?</span></a>\n");
      out.write("                                                \n");
      out.write("                                                <div id=\"pages\" class=\"collapse\">\n");
      out.write("                                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${yetki==\"Admin\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" > \n");
      out.write("                                                    <ul class=\"sidebar-menu list-unstyled border-left border-primary border-thick\">\n");
      out.write("                                                        <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/new\" class=\"sidebar-link text-muted pl-lg-5\">Kullan?c? Kay?t</a></li>\n");
      out.write("                                                        <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/list\" class=\"sidebar-link text-muted pl-lg-5\">Kullan?c? Listesi</a></li>\n");
      out.write("                                                    </ul>\n");
      out.write("                                                </div>\n");
      out.write("                                                    </c:if>\n");
      out.write("                                                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${yetki==\"User\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" > \n");
      out.write("                                                    <ul class=\"sidebar-menu list-unstyled border-left border-primary border-thick\">\n");
      out.write("                                                        <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/home\" class=\"sidebar-link text-muted pl-lg-5\">Kullan?c? Kay?t</a></li>\n");
      out.write("                                                        <li class=\"sidebar-list-item\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/home\" class=\"sidebar-link text-muted pl-lg-5\">Kullan?c? Listesi</a></li>\n");
      out.write("                                                    </ul>\n");
      out.write("                                                </div>\n");
      out.write("                                                    </c:if>\n");
      out.write("                                            </li>\n");
      out.write("                                                </c:if>\n");
      out.write("                                            <li class=\"sidebar-list-item\"><a href=\"index.jsp\" class=\"sidebar-link text-muted\"><i class=\"o-exit-1 mr-3 text-gray\"></i><span>Login</span></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>");
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
