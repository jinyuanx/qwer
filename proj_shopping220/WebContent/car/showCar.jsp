<%@page import="com.it.bean.GoodsDetails"%>
<%@page import="java.util.*,com.it.bean.GoodsInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询页面</title>
<style>
body {
	text-align: center;
}

table {
	border: 1px solid blue;
	width: 600px;
	height: 300px;
	margin-top: 50px;
	border-collapse: collapse;
}

form {
	width: 600px;
}

td, th {
	border: 1px solid black;
	text-align: center
}

a {
	text-decoration: none
}
</style>
</head>
<body>
	<center>
		<h1>

			<marquee>
				<font color="red">欢迎进入本网站！！！！！！</font>
			</marquee>
		</h1>


	</center>
	<%
	
	List<GoodsDetails> car = (List<GoodsDetails>)session.getAttribute("car");
	
	%>
	<table align="center">
		<tr>
			<th>序号</th>
			<th>商品编号</th>
			<th>商品名</th>
			<th>价格</th>
			<th>数量</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		
		<%
		
		  double sum = 0;
		  for(int i = 0;i<car.size();i++){
		%>
		<tr>
		<form action="../buy.do?opt=upd" method="post">
		<td><%=i+1 %></td>
		<td><%=car.get(i).getGoodsInfo().getGoods_Id() %></td>
		<td><%=car.get(i).getGoodsInfo().getGoods_Name() %></td>
		<td><%=car.get(i).getGoodsInfo().getGoods_Price() %></td>
		<%-- <td><%=car.get(i).getCount() %></td> --%>
		<input type="hidden" name="goods_Id" value="<%=car.get(i).getGoodsInfo().getGoods_Id() %>">
		<td>
		<input type="text" name="count" value="<%=car.get(i).getCount() %>" size="2">
		</td>
		<td><%=Double.parseDouble(car.get(i).getGoodsInfo().getGoods_Price())*car.get(i).getCount() %></td>
	    <td>
	     <a href="../buy.do?opt=del&goods_Id=<%=car.get(i).getGoodsInfo().getGoods_Id() %>">删除</a>
	     &nbsp; &nbsp; &nbsp; &nbsp;
	     <input type="submit" value="修改">
	   
	    </td>
	       </form>
		</tr>
		<% sum+=Double.parseDouble(car.get(i).getGoodsInfo().getGoods_Price())*car.get(i).getCount(); %>
		
		<%} %>
		
		
		</table>
	<br><br><br><br>
<a href="../show.do">继续购物</a> &nbsp;&nbsp;&nbsp;&nbsp;
总计:<%=sum %>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="../buy.do?opt=cls">清空购物车</a>

</body>
</html>