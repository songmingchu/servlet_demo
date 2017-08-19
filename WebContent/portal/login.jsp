<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>登录/注册</title>

<link href="/servlet_demo/static/css/bootstrap.min.css" rel="stylesheet">
<script src="/servlet_demo/static/js/jquery-2.1.0.min.js"></script>
<script src="/servlet_demo/static/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">我的网站</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"> 注册</a></li>
				<li><a href="#"> 登录</a></li>
			</ul>
		</div>
		</nav>

		<form class="form-horizontal" role="form" action="../login" type="get">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">账号：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="username"
						placeholder="请输入账号">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">密码：</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" name="password"
						placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">登录</button>
				</div>
			</div>
		</form>



	</div>
</body>
</html>