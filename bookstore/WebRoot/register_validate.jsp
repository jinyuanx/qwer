<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="control.*"%>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册验证</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String sex = request.getParameter("sex");
	String money = request.getParameter("money");
	request.setAttribute("id", id);
	//out.println(id+password+email+name+age+sex);
	//PreparedStatement pst = null;
	//ConnectSql sql = new ConnectSql();
	User user = new User(id,password,email,name,age,sex,money);
	register re = new register();
	if(re.add(user,id)){
		String index = "login.jsp?username=" + URLEncoder.encode(id, "utf-8");
		out.println("注册成功！2s后跳转到<a href=" + index + ">登陆界面</a>");
		response.addHeader("refresh", "2;URL=login.jsp?username=" + URLEncoder.encode(id, "utf-8"));
	}else{
		out.println("当前账号已经注册过了");
		String index = "register.jsp?username=" + URLEncoder.encode(id, "utf-8");
		out.println("注册失败！2s后跳转到<a href=" + index + ">注册界面</a>");
		response.addHeader("refresh", "2;URL=register.jsp?username=" + URLEncoder.encode(id, "utf-8"));
	}
	
/* 	if(id.substring(0, 2).equals("sj")){
		try{
			Connection conn = sql.getConn("my_test", "store");
			
			String u = null;
			Statement st = conn.createStatement();
			String s = "insert into store (id,password,email,name,age,sex) values (?,?,?,?,?,?)";
			String ss = "select * from store";
			ResultSet rs = st.executeQuery(ss);
			boolean flag = false;
			while (rs.next()) {
				u = rs.getString("id");
				if(u.equals(id)){
					flag = true;
					break;
				}
			}
			if(!flag){
				pst=conn.prepareStatement(s);
				pst.setString(1,id);
				pst.setString(2,password);
				pst.setString(3,email);
				pst.setString(4,name);
				pst.setString(5,age);
				pst.setString(6,sex);
				pst.executeUpdate();
				String index = "login.jsp?username=" + URLEncoder.encode(id, "utf-8");
				out.println("注册成功！2s后跳转到<a href=" + index + ">登陆界面</a>");
				response.addHeader("refresh", "2;URL=login.jsp?username=" + URLEncoder.encode(id, "utf-8"));
				rs.close();
				conn.close();
				return;
			}else{
				out.println("当前账号已经注册过了");
				String index = "register.jsp?username=" + URLEncoder.encode(id, "utf-8");
				out.println("注册失败！2s后跳转到<a href=" + index + ">注册界面</a>");
				response.addHeader("refresh", "2;URL=register.jsp?username=" + URLEncoder.encode(id, "utf-8"));
				rs.close();
				conn.close();
				return;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}else {
		try{
			Connection conn = sql.getConn("my_test", "user");
			
			String u = null;
			Statement st = conn.createStatement();
			String s = "insert into user (id,password,email,name,age,sex) values (?,?,?,?,?,?)";
			String ss = "select * from user";
			ResultSet rs = st.executeQuery(ss);
			boolean flag = false;
			while (rs.next()) {
				u = rs.getString("id");
				if(u.equals(id)){
					flag = true;
					break;
				}
			}
			if(!flag){
				pst=conn.prepareStatement(s);
				pst.setString(1,id);
				pst.setString(2,password);
				pst.setString(3,email);
				pst.setString(4,name);
				pst.setString(5,age);
				pst.setString(6,sex);
				pst.executeUpdate();
				String index = "login.jsp?username=" + URLEncoder.encode(id, "utf-8");
				out.println("注册成功！2s后跳转到<a href=" + index + ">登陆界面</a>");
				response.addHeader("refresh", "2;URL=login.jsp?username=" + URLEncoder.encode(id, "utf-8"));
				rs.close();
				conn.close();
				return;
			}else{
				out.println("当前账号已经注册过了");
				String index = "register.jsp?username=" + URLEncoder.encode(id, "utf-8");
				out.println("注册失败！2s后跳转到<a href=" + index + ">注册界面</a>");
				response.addHeader("refresh", "2;URL=register.jsp?username=" + URLEncoder.encode(id, "utf-8"));
				rs.close();
				conn.close();
				return;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	} */
	
	%>
</body>
</html>