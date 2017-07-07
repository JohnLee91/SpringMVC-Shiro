<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>脚手架</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout-default-latest.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

<%--<iframe name="content" class="ui-layout-center"--%>
        <%--src="${pageContext.request.contextPath}/welcome" frameborder="0" scrolling="auto"></iframe>--%>
<div class="ui-layout-center">
    <div class="row">
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/resources/static/picture/hard.png" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/resources/static/picture/hard.png" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/resources/static/picture/hard.png" alt="...">
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/resources/static/picture/hard.png" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/resources/static/picture/hard.png" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/resources/static/picture/hard.png" alt="...">
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/resources/static/picture/hard.png" alt="...">
            </a>
        </div>
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="${pageContext.request.contextPath}/resources/static/picture/hard.png" alt="...">
            </a>
        </div>
    </div>
</div>
<div class="ui-layout-north">欢迎您[<shiro:principal/>]，<a href="${pageContext.request.contextPath}/logout">退出</a></div>
<div class="ui-layout-south" style="text-align: center">
    COPYRIGHT 2016 www.scsics.com <br>
    友情链接：<a href="http://www.scsics.com" target="_blank">四川省计算机研究院</a>
</div>
<div class="ui-layout-west">
    <%--功能菜单<br/>--%>
    <%--<c:forEach items="${menus}" var="m">--%>
        <%--<a href="${pageContext.request.contextPath}${m.url}" target="content">${m.name}</a><br/>--%>
    <%--</c:forEach>--%>
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#example-navbar-collapse">
                        <span class="sr-only">切换导航</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">矿石图形库</a>
                </div>
                <div class="collapse navbar-collapse" id="example-navbar-collapse">
                    <ul class="nav nav-pills ">
                        <li role="presentation" ><a href="#">易选矿石</a></li>
                        <li role="presentation" ><a href="#">中等可选矿石</a></li>
                        <li role="presentation" class="active"><a href="#">难选矿石</a></li>
                    </ul>
                </div>
            </div>
        </nav>
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