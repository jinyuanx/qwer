<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="login_box">
		<div class="login_l_img">
			<img src="images/login-img.png" />
		</div>
		<div class="login">
			<div class="login_logo">
				<a href="#"><img src="images/login_logo.png" /></a>
			</div>
			<div class="login_name">
				<p>欢迎登陆</p>
			</div>
			<form  name="form" action="login_validate.jsp" method="post">
				<input name="username" type="text" value="用户名"
					onfocus="this.value=''"
					onblur="if(this.value==''){this.value='用户名'}"> <span
					id="password_text"
					onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();">密码</span>
				<input name="password" type="password" id="password"
					style="display: none;"
					onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};" />
				<input value="登录" style="width: 100%;" type="submit">
				<hr>
				<a href="register.jsp"><input value="注册" style="width: 100%;" type="button"></a>
			</form>
		</div>
		<div class="copyright">桦哥有限公司 版权所有©2022-99999 技术支持电话：15354511033</div>
	</div>
</body>
</html>