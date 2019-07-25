<%@page import="java.util.*,com.it.bean.GoodsDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
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
<script src="../js/jquery-2.1.0.js"></script>
<script type="text/javascript">

  $(function(){
	  
	  //给添加按钮绑定单击事件
	  
	   
	 
	  
	  
  });
   
  function add(id){
	//  alert(id);
	  var count = window.parseInt(document.getElementById(id).value);
	 // alert(count);
	   count++;
	   document.getElementById(id).value=count;
  }
  
  function minus(id){
	//  alert(id);
	  var count = window.parseInt(document.getElementById(id).value);
	 // alert(count);
	 if(count>1){
		 count--;
	 }
	   
	   document.getElementById(id).value=count;
	   
  }
    function delCar(id){
    	
    	  var flag = window.confirm("确定移除吗?");
		   if(flag){
			   
			   window.location.href="../buy.do?opt=del&goods_Id="+id;
			   
		   }
    }
</script>
</head>
<body>


<br><br>
<center>
		<h1>

			<marquee>
				<font color="red">欢迎查看购物车！！！！！！</font>
			</marquee>
		</h1>
		
		
	</center>
	<%
	  List<GoodsDetails> gds = (List<GoodsDetails>)session.getAttribute("car");
	
	  if(gds==null || gds.size()==0){
		  
	  
	%>
	
	<script type="text/javascript">
	
	  alert("购物车为空!!请去购买!!");
	  window.location.href="../showGoods";
	</script>
	
	<% return;} %>
	<table align="center">
		<tr>
			<th>序号</th>
			<th>商品编号</th>
			<th>商品名</th>
			<th>价格</th>
			<th>数量</th>
			<th>操作</th>
		</tr>
		<%
		
		   double sum = 0;
		  for(int i = 0;i<gds.size();i++){
		
		%>
		<form action="../buy.do?opt=upd" method="post">
		<input type="hidden" name="goods_Id" value="<%=gds.get(i).getGoodsInfo().getGoods_Id() %>">
		<tr>
		    <td><%=i+1 %></td>
		    <td><%=gds.get(i).getGoodsInfo().getGoods_Id() %></td>
		    <td><%=gds.get(i).getGoodsInfo().getGoods_Name() %></td>
		    <td><%=gds.get(i).getGoodsInfo().getGoods_Price() %></td>
		    <td>
		      <input type="button" value="  +  " id="btnAdd" onclick="add('<%=gds.get(i).getGoodsInfo().getGoods_Id()%>')" />
		      <input type="text" id="<%=gds.get(i).getGoodsInfo().getGoods_Id()%>" name="count" value="<%=gds.get(i).getCount()%>" size="1">
		      <input type="button" value="  -  " id="btnRe"  onclick="minus('<%=gds.get(i).getGoodsInfo().getGoods_Id()%>')"/>
		    </td>
		    <td>
		      <input type="button" id="delbtn" value="移除" onclick="delCar('<%=gds.get(i).getGoodsInfo().getGoods_Id() %>')">
		      &nbsp; &nbsp;
		      <input type="submit" id="updbtn" value="修改">
		    </td>
		</tr>
		</form>
		
		<%
		
		    sum+=Double.parseDouble(gds.get(i).getGoodsInfo().getGoods_Price())  *gds.get(i).getCount();
		  } %>
		</table>
	<p align="left"><a href="../showGoods">继续购物</a>
	
	  总计:<font color="red"><%=sum %></font>RMB&nbsp;&nbsp;&nbsp;&nbsp;
	  <a href="../buy.do?opt=cls">清空购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;
	  <a href="../order.do?total=<%=sum %>">结算</a>
		</p>
<center>
		<h1>

			<marquee>
				<font color="red">jstl+el欢迎查看购物车！！！！！！</font>
			</marquee>
		</h1>
		
		
	</center>
	<table align="center">
		<tr>
			<th>序号</th>
			<th>商品编号</th>
			<th>商品名</th>
			<th>价格</th>
			<th>数量</th>
			<th>操作</th>
		</tr>
	
		<c:forEach var="gdsl" items="${car }" varStatus="i">
		
		   <tr>
		      <td>${i.index+1 }</td>
		      <td>${gdsl.goodsInfo.goods_Id}</td>
		       <td>${gdsl.goodsInfo.goods_Name}</td>
		        <td>${gdsl.goodsInfo.goods_Price}</td>
		        <td>${gdsl.count}</td>
		        
		        <td>
		          <a href="#">移除</a>
		          &nbsp;&nbsp;
		          <a href="#">修改</a>
		        </td>
		   </tr>
		  <c:set value="${sums+gdsl.goodsInfo.goods_Price*gdsl.count }" var="sums" ></c:set>
		</c:forEach>
		</table>
		<p align="left"><a href="../showGoods">继续购物</a>
	
	  总计:<font color="red">${sums }</font>RMB
		</p>
<hr>

</body>
</html>