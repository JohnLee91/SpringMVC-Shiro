<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
   <head>
      <title>理论值预测页</title>
      <%--<%@include file="./common/head.jsp"%>--%>
	   <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	   <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	   <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	   <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	   <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	   <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   </head>
   <body>
   	<div class="container">
   		<div class="panel panel-default">
   			<div class="panel-heading text-center">
   				<h2>理论值预测</h2>
   			</div>
   			<div class="table-responsive">
   				<table class="table table-bordered">
   					<thead>
   						<tr class="success">
							<th>选择</th>
   							<th>矿物名称</th>
   							<th>矿物含量/%</th>
   							<th>单矿物稀土总量/%</th>
   							<th>稀土金属量/%</th>
   							<th>稀土在矿物中的配分比/%</th>
   						</tr>
   					</thead>
   					<tbody>
						<tr class="info">
							<td>
								<div class="checkbox-inline">
									<label>
										<input type="checkbox">
									</label>
								</div>
							</td>
							<td>
								<input type="text" value="独居石" class="form-control">
							</td>
							<td>
								<input type="text" value="6.22" class="form-control">
							</td>
							<td>
								<input type="text" value="58.28" class="form-control">
							</td>
							<td style="vertical-align: middle;color: red">
								3.628
							</td>
							<td style="vertical-align: middle;color: red">
								88.53
							</td>
						</tr>
						<tr class="info">
							<td>
								<div class="checkbox-inline">
									<label>
										<input type="checkbox">
									</label>
								</div>
							</td>
							<td>
								<input type="text" value="磷灰石" class="form-control">
							</td>
							<td>
								<input type="text" value="1.63" class="form-control">
							</td>
							<td>
								<input type="text" value="0.79" class="form-control">
							</td>
							<td style="vertical-align: middle;color: red">
								0.013
							</td>
							<td style="vertical-align: middle;color: red">
								0.31
							</td>
						</tr>
						<tr>
							<td>
								<div class="checkbox-inline">
									<label>
										<input type="checkbox">
									</label>
								</div>
							</td>
							<td>
								<input type="text" value="胶磷矿" class="form-control">
							</td>
							<td>
								<input type="text" value="1.63" class="form-control">
							</td>
							<td>
								<input type="text" value="1.37" class="form-control">
							</td>
							<td style="vertical-align: middle;color: red">
								0.022
							</td>
							<td style="vertical-align: middle;color: red">
								0.55
							</td>
						</tr>
						<tr class="info">
							<td>
								<div class="checkbox-inline">
									<label>
										<input type="checkbox">
									</label>
								</div>
							</td>
							<td>
								<input type="text" value="磷铝铈矿" class="form-control">
							</td>
							<td>
								<input type="text" value="4.73" class="form-control">
							</td>
							<td>
								<input type="text" value="9.19" class="form-control">
							</td>
							<td style="vertical-align: middle;color: red">
								0.435
							</td>
							<td style="vertical-align: middle;color: red">
								10.61
							</td>
						</tr>
						<tr>
							<td style="vertical-align: middle">
								合计
							</td>
							<td style="vertical-align: middle">

							</td>
							<td style="vertical-align: middle;color: red">
								14.21
							</td>
							<td>

							</td>
							<td style="vertical-align: middle;color: red">
								4.098
							</td>
							<td style="vertical-align: middle;color: red">
								100
							</td>
						</tr>
   					</tbody>
   				</table>
   			</div>
   		</div>
		<table class="table">
			<tr>
				<td style="vertical-align: middle;width: 15%">化学多项式分析结果/%</td>
				<td>
					<input type="text" value="4.523" class="form-control">
				</td>
			</tr>
			<tr>
				<td style="vertical-align: middle;width: 15%">理论品位/%</td>
				<td style="vertical-align: middle;color: red">
					32.4
				</td>
			</tr>
			<tr>
				<td style="vertical-align: middle;width: 15%">理论回收率/%</td>
				<td style="vertical-align: middle;color: red">
					90.117
				</td>
			</tr>
			<tr>
				<td style="vertical-align: middle;width: 15%">平衡系数K/%</td>
				<td style="vertical-align: middle;color: red">
					9.396
				</td>
			</tr>
		</table>
		<div class="panel-heading text-center">
			<button class="btn btn-info" type="submit">计算</button>
		</div>
   	</div>
   </body>
</html></th>