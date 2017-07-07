<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>脚手架</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout-default-latest.css">
</head>
<body>

<iframe name="content" class="ui-layout-center"
        src="${pageContext.request.contextPath}/welcome" frameborder="0" scrolling="auto"></iframe>
<div class="ui-layout-north">欢迎您[<shiro:principal/>]，<a href="${pageContext.request.contextPath}/logout">退出</a></div>
<div class="ui-layout-south" style="text-align: center">
    COPYRIGHT 2016 www.scsics.com <br>
    友情链接：<a href="http://www.scsics.com" target="_blank">四川省计算机研究院</a>
</div>
<div class="ui-layout-west">
    功能菜单<br/>
    <c:forEach items="${menus}" var="m">
        <a href="${pageContext.request.contextPath}${m.url}" target="content">${m.name}</a><br/>
    </c:forEach>
</div>


<script src="${pageContext.request.contextPath}/resources/static/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/jquery.layout-latest.min.js"></script>
<script>
    $(function () {
        $(document).ready(function () {
            $('body').layout({ applyDemoStyles: true });
        });
    });
</script>
</body>
</html>