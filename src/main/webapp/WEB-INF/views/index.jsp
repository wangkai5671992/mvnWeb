<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common/include.jsp"%>
<title>登录</title>
</head>
<body>
	<br>
	<br>
	<br>
	<form class="form-horizontal" role="form"
		action="${BASE_FRONT}/log/login" method="post">
		<div class="form-group">
			<label for="username" class="col-lg-2 control-label">账号</label>
			<div class="col-lg-4">
				<input type="text" class="form-control" id="username"
					name="username" placeholder="请输入账号">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-lg-2 control-label">密码</label>
			<div class="col-lg-4">
				<input type="text" class="form-control" id="password"
					name="password" placeholder="请输入密码">
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-4">
				<div class="checkbox">
					<label> <input type="checkbox">记住密码
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-4">
				<input type="submit" value="登录" class="btn btn-default">
			</div>
		</div>
	</form>
</body>
</html>