<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./common/tag.jsp"%>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
    <%--<%@include file="./common/head.jsp"%>--%>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath %>">
</head>
<body>

<div class="error">${error}</div>
<form action="" method="post">
    用户名：<input type="text" name="username" value="<shiro:principal/>"><br/>
    密码：<input type="password" name="password"><br/>
    自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
    <%-- jcaptchaEbabled 在JCaptchaValidateFilter设置 --%>
    <c:if test="${jcaptchaEbabled}">
        验证码：
        <input type="text" name="jcaptchaCode">
        <img class="jcaptcha-btn jcaptcha-img" src="${pageContext.request.contextPath}/jcaptcha.jpg" title="点击更换验证码">
        <a class="jcaptcha-btn" href="javascript:;">换一张</a>
        <br/>
    </c:if>
    <input type="submit" value="登录">
</form>
<script>
    $(function() {
        $(".jcaptcha-btn").click(function() {
            //+new Date().getTime());
            $(".jcaptcha-img").attr("src", '${pageContext.request.contextPath}/jcaptcha.jpg?'+new Date().getTime());
        });
    });
</script>
</body>
</html>