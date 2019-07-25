<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="login_box">

		<div class="login_name">
			<p>欢迎注册</p>
		</div>
		<form name="form" action="register_validate.jsp" method="post">
			<p>如果是商家注册，请在用户名前加上‘sj’两个字母</p>
			<input name="id" type="text" value="用户名" onfocus="this.value=''"
				onblur="if(this.value==''){this.value='用户名'}"> 
			
			<input
				name="password" type="text" value="密码" onfocus="this.value=''"
				onblur="if(this.value==''){this.value='密码'}"> 
			<input
				name="email" type="text" value="邮件" onfocus="this.value=''"
				onblur="if(this.value==''){this.value='邮件'}"> 
			<input
				name="name" type="text" value="姓名" onfocus="this.value=''"
				onblur="if(this.value==''){this.value='姓名'}"> 
			<input
				name="age" type="text" value="年龄" onfocus="this.value=''"
				onblur="if(this.value==''){this.value='年龄'}"> 
			<input
				name="sex" type="text" value="性别" onfocus="this.value=''"
				onblur="if(this.value==''){this.value='性别'}"> 
			<input
				name="money" type="text" value="注册资金" onfocus="this.value=''"
				onblur="if(this.value==''){this.value='注册资金'}"> 
			<input
				value="确认" style="width: 100%;" type="submit">
			<hr>
			<a href="login.jsp"><input value="取消" style="width: 100%;"
				type="button"></a>
		</form>

	</div>
</body>
</html>