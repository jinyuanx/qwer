<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="control.*"%>
<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆验证</title>
</head>
<body>
	<%
		String id = request.getParameter("username");
		String pwd = request.getParameter("password");
		request.setAttribute("username", id);
		
		login lo = new login();
		int i = lo.ask(id,pwd);
		if(i == 1){
			String index = "admin.jsp?username=" + URLEncoder.encode(id, "utf-8");
			out.println("管理员登陆成功！2s后跳转到<a href=" + index + ">后台管理</a>");
			response.addHeader("refresh", "2;URL=admin.jsp?username=" + URLEncoder.encode(id, "utf-8"));
		}else if(i == 2){
			String index = "index.jsp?username=" + URLEncoder.encode(id, "utf-8");
			out.println("商家登陆成功！2s后跳转到<a href=" + index + ">商家页面</a>");
			response.addHeader("refresh", "2;URL=store.jsp?username=" + URLEncoder.encode(id, "utf-8"));
		}else if(i == 3){
			String index = "index.jsp?username=" + URLEncoder.encode(id, "utf-8");
			out.println("用户登陆成功！2s后跳转到<a href=" + index + ">欢迎页</a>");
			response.addHeader("refresh", "2;URL=index.jsp?username=" + URLEncoder.encode(id, "utf-8"));
		}else{
			out.println("用户名或密码错误");
		}
/* 		ConnectSql sql = new ConnectSql();

		if (id.equals("sa")) {
			try {
				Connection conn = sql.getConn("my_test", "admin");

				String u = null;
				String p = null;
				Statement st = conn.createStatement();
				String s = "select * from admin";
				ResultSet rs = st.executeQuery(s);
				while (rs.next()) {
					u = rs.getString("id");
					p = rs.getString("password");
					if (u.equals(id) && p.equals(pwd)) {
						String index = "admin.jsp?username=" + URLEncoder.encode(id, "utf-8");
						out.println("管理员登陆成功！2s后跳转到<a href=" + index + ">后台管理</a>");
						response.addHeader("refresh", "2;URL=admin.jsp?username=" + URLEncoder.encode(id, "utf-8"));
						rs.close();
						conn.close();
						return;
					}
					
					
				}
				rs.close();
				conn.close();
				out.println("用户名或密码错误");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(id.substring(0, 2).equals("sj")){
			try {
				Connection conn = sql.getConn("my_test", "store");
				String u = null;
				String p = null;
				Statement st = conn.createStatement();
				String s = "select * from store";
				ResultSet rs = st.executeQuery(s);
				while (rs.next()) {
					u = rs.getString("id");
					p = rs.getString("password");
					if (u.equals(id) && p.equals(pwd)) {
						String index = "index.jsp?username=" + URLEncoder.encode(id, "utf-8");
						out.println("商家登陆成功！2s后跳转到<a href=" + index + ">商家页面</a>");
						response.addHeader("refresh", "2;URL=store.jsp?username=" + URLEncoder.encode(id, "utf-8"));
						rs.close();
						conn.close();
						return;
					}
					
					
				}
				rs.close();
				conn.close();
				out.println("用户名或密码错误");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				Connection conn = sql.getConn("my_test", "user");
				String u = null;
				String p = null;
				Statement st = conn.createStatement();
				String s = "select * from user";
				ResultSet rs = st.executeQuery(s);
				while (rs.next()) {
					u = rs.getString("id");
					p = rs.getString("password");
					if (u.equals(id) && p.equals(pwd)) {
						String index = "index.jsp?username=" + URLEncoder.encode(id, "utf-8");
						out.println("用户登陆成功！2s后跳转到<a href=" + index + ">欢迎页</a>");
						response.addHeader("refresh", "2;URL=index.jsp?username=" + URLEncoder.encode(id, "utf-8"));
						rs.close();
						conn.close();
						return;
					}
					
					
				}
				rs.close();
				conn.close();
				out.println("用户名或密码错误");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} */
	%>
	<form>
		<input type="hidden" name="username" value="${param.username}">
		<input type="button" value="重新登陆"
			onclick="this.form.action='login.jsp';this.form.submit();">
	</form>
</body>
</html>