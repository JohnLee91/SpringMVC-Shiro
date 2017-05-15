package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/jsp/common/head.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("      <title>秒杀详情页</title>\r\n");
      out.write("      ");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<!-- å¼å¥ Bootstrap -->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- HTML5 Shim å Respond.js ç¨äºè®© IE8 æ¯æ HTML5åç´ ååªä½æ¥è¯¢ -->\r\n");
      out.write("<!-- æ³¨æï¼ å¦æéè¿ file://  å¼å¥ Respond.js æä»¶ï¼åè¯¥æä»¶æ æ³èµ·ææ -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("         <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("         <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\r\n");
      out.write("      <![endif]-->\r\n");
      out.write("    <!-- jQueryæä»¶ãå¡å¿å¨bootstrap.min.js ä¹åå¼å¥ -->\r\n");
      out.write("    <script src=\"http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js\"></script>\r\n");
      out.write("    <!-- ææ°ç Bootstrap æ ¸å¿ JavaScript æä»¶ -->\r\n");
      out.write("    <script src=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<base href=\"");
      out.print(basePath );
      out.write("\">      ");
      out.write("\r\n");
      out.write("   </head>\r\n");
      out.write("   <body>\r\n");
      out.write("   \t<div class=\"container\">\r\n");
      out.write("   \t\t<div class=\"panel panel-default text-center\">\r\n");
      out.write("   \t\t\t<div class=\"panel-heading\">\r\n");
      out.write("   \t\t\t\t<h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seckill.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h1>\r\n");
      out.write("   \t\t\t</div>\r\n");
      out.write("   \t\t\t<div class=\"panel-body\">\r\n");
      out.write("   \t\t\t\t<h2 class=\"text-danger\">\r\n");
      out.write("   \t\t\t\t\t<!-- 显示time图标 -->\r\n");
      out.write("   \t\t\t\t\t<span class=\"glyphicon glyphicon-time\"></span>\r\n");
      out.write("   \t\t\t\t\t<!-- 展示倒计时 -->\r\n");
      out.write("   \t\t\t\t\t<span class=\"glyphicon\" id=\"seckill-box\"></span>\r\n");
      out.write("   \t\t\t\t</h2>\r\n");
      out.write("   \t\t\t</div>\r\n");
      out.write("   \t\t</div>\r\n");
      out.write("   \t</div>\r\n");
      out.write(" \t<!-- 登陆弹出层，输入电话 -->\r\n");
      out.write("    <div id=\"killPhoneModal\" class=\"modal fade\">\r\n");
      out.write("    \t<div class=\"modal-dialog\">\r\n");
      out.write("    \t\t<div class=\"modal-content\">\r\n");
      out.write("    \t\t\t<div class=\"modal-header\">\r\n");
      out.write("    \t\t\t\t<h3 class=\"modal-title text-center\">\r\n");
      out.write("    \t\t\t\t\t<span class=\"glyphicon glyphicon-phone\"></span>秒杀电话：\r\n");
      out.write("    \t\t\t\t</h3>\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t\t<div class=\"modal-body\">\r\n");
      out.write("    \t\t\t\t<div class=\"row\">\r\n");
      out.write("    \t\t\t\t\t<div class=\"col-xs-8 col-xs-offset-2\">\r\n");
      out.write("    \t\t\t\t\t\t<input type=\"text\" name=\"killPhone\" id=\"killPhoneKey\"\r\n");
      out.write("    \t\t\t\t\t\t\t\tplaceholder=\"填手机号^o^\" class=\"form-control\"/>\r\n");
      out.write("    \t\t\t\t\t</div>\r\n");
      out.write("    \t\t\t\t</div>\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t\t<div class=\"modal-footer\">\r\n");
      out.write("    \t\t\t\t<!-- 验证信息 -->\r\n");
      out.write("    \t\t\t\t<span id=\"killPhoneMessage\" class=\"glyphicon\"></span>\r\n");
      out.write("    \t\t\t\t<button type=\"button\" id=\"killPhoneBtn\" class=\"btn btn-success\">\r\n");
      out.write("    \t\t\t\t\t<span class=\"glyphicon glyphicon-phone\"></span>\r\n");
      out.write("    \t\t\t\t\tSubmit\r\n");
      out.write("    \t\t\t\t</button>\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t</div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("   </body>\r\n");
      out.write("\r\n");
      out.write("   <!-- 使用cdn获取公共js http://www.bootcdn.cn -->\r\n");
      out.write("   <!-- jQuery cookie操作插件 -->\r\n");
      out.write("   <script src=\"http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js\"></script>\r\n");
      out.write("   <!-- jQuery countDown倒计时插件 -->\r\n");
      out.write("   <script src=\"http://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js\"></script>\r\n");
      out.write("   <!-- 开始编写交互逻辑 -->\r\n");
      out.write("   <script src=\"/SeckillSys/resources/script/seckill.js\" type=\"text/javascript\"></script>\r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write("   \t\t$(function(){\r\n");
      out.write("   \t\t\t//使用EL表达式传入参数\r\n");
      out.write("   \t\t\tseckill.detail.init({\r\n");
      out.write("   \t\t\t\t'seckillId' : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seckill.seckillId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("   \t\t\t\t'startTime' : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seckill.startTime.time}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("',//毫秒\r\n");
      out.write("   \t\t\t\t'endTime' : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seckill.endTime.time}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("'\r\n");
      out.write("   \t\t\t});\r\n");
      out.write("   \t\t});\r\n");
      out.write("   </script>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
