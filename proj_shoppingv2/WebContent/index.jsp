<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
欢迎<font color="red" size="5">${users.user_id }</font>登录本网站！
&nbsp;&nbsp;
现在时刻:<%=new Date().toLocaleString() %>
<center>

<h2>
<a href="showGoods">查看商品</a>&nbsp;&nbsp;&nbsp;
<a href="car/showCar.jsp">查看购物车</a><br><br>
</h2>
</center>
</body>
</html>