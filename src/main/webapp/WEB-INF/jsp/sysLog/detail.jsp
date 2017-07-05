<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>日志详情页</title>
      <%@include file="../common/head.jsp"%>
   </head>
   <body>
   	<div class="container">
   		<div class="panel panel-default text-center">
   			<div class="panel-heading">
   				<h1>详细内容</h1>
   			</div>
   			<div class="panel-body">
   			</div>
   		</div>
   	</div>
	<div class="container">
		<div class="panel panel-default text-center">
			<div class="panel-heading">
				<p>${sysLog.content}</p>
			</div>
			<div class="panel-body">
			</div>
		</div>
	</div>
   </body>
</html>