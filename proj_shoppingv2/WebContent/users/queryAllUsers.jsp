<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.List,com.it.bean.Users"%>
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
<script type="text/javascript">
	function checkDel(id) {

		var flag = window.confirm("确定删除吗?");
		if (flag) {
			window.location.href = "doDel.jsp?user_id=" + id;
			alert("恭喜您删除成功!");
		}
	}
</script>
</head>
<body>
<center>
		<h1>

			<marquee>
				<font color="red">欢迎您进入本网站！！！</font>
			</marquee>
		</h1>
		<form action="user.do?opt=queryAll" method="post">

			用户名:<input type="text" name="user_name" id="user_name" /> &nbsp;
			&nbsp; &nbsp; &nbsp; 年龄:<input type="text" name="user_age"
				id="user_age" /> &nbsp; &nbsp; &nbsp; &nbsp; <input type="submit"
				value="查   询" />
		</form>
	</center>
	
	

	<table align="center">
		<tr>
			<th>序号</th>
			<th>编号</th>
			<th>用户名</th>
			<th>年龄</th>
			<th>体重</th>
			<th>操作</th>
			<%
	
	     List<Users> listU = (List<Users>)request.getAttribute("listU");
			
			for(int i = 0;i<listU.size();i++){
	%>
	      <tr>
	          <td><%=(i+1) %></td>
	          <td><%=listU.get(i).getUser_id()%></td>
	           <td><%=listU.get(i).getUser_name()%></td>
	            <td><%=listU.get(i).getUser_age()%></td>
	             <td><%=listU.get(i).getUser_weight()%></td>
	      	<td>
	      	   <a href="#" onclick="checkDel('<%=listU.get(i).getUser_id()%>')">删除</a>&nbsp;&nbsp; <a
				href="user.do?opt=findById&user_id=<%=listU.get(i).getUser_id()%>">修改</a>
	      	</td>
	      </tr>
	
	<%} %>
		</tr>
		</table>
</body>
</html>