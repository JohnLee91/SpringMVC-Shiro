<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
   <head>
      <title>日志列表页</title>
      <%@include file="../common/head.jsp"%>
   </head>
   <body>
   	<div class="container">
   		<div class="panel panel-default">
   			<div class="panel-heading text-center">
   				<h2>日志列表</h2>
   			</div>
   			<div class="panel-body">
   				<table class="table table-hover">
   					<thead>
   						<tr>
   							<th>用户名</th>
   							<th>操作IP</th>
   							<th>模块名</th>
   							<th>操作类型</th>
   							<th>操作内容</th>
   							<th>操作时间</th>
							<th>操作</th>
   						</tr>
   					</thead>
   					<tbody>
   						<c:forEach var="log" items="${sysLogList}">
   							<tr>
   								<td>${log.user.username}</td>
   								<td>${log.ip}</td>
   								<td>${log.moduleName}</td>
   								<td>${log.options}</td>
								<td>${log.content}</td>
   								<td>
									<fmt:formatDate value="${log.optTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
   								</td>
   								<td>
									<shiro:hasPermission name="sysLog:view">
   										<a class="btn btn-info" href="sysLog/${log.id}/detail" target="_self">详情</a>
									</shiro:hasPermission>
   								</td>
   							</tr>
   						</c:forEach>
   					</tbody>
   				</table>
   			</div>
   		</div>
   	</div>
   </body>
</html></th>