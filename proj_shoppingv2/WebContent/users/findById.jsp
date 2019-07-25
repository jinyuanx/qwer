<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.it.bean.Users"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
			#form{
				height: 500px;
				padding-top: 70px;
				margin-bottom: 10px;
			}
			a{
				text-decoration: none;
			}	
			#father{
				border: 0px solid white;
				padding-left: 307px;
			}
			
			#form2{
				border: 5px solid gray;
				width: 660px;
				height: 450px;
			}		
		</style>
		<script src="js/jquery-2.1.0.js"></script>
	 <script type="text/javascript" src="js/jquery.validate.min.js" ></script>
	 <script type="text/javascript" src="js/messages_zh.js" ></script>
	 <script>
	 	$(function(){
	 		$("#registForm").validate({
	 			rules:{
	 				user_name:{
	 					required:true,
	 					minlength:5
	 				},
	 				user_age:{
	 					required:true,
	 					digits:true
	 				},
	 				user_weight:{
	 					required:true,
	 					digits:true
	 					
	 				}
	 			},
	 			messages:{
	 				user_name:{
	 					required:"用户名必填!",
	 					minlength:"用户名长度至少是5!"
	 				},
	 				user_age:{
	 					required:"年龄必填!",
	 					digits:"年龄必须是数字"
	 				},
	 				
	 				
	 				user_weight:{
	 					required:"体重必填!",
	 					digits:"体重必须是数字"
	 				}
	 			}
	 			
	 		});
	 		
	 	});
	 </script>
</head>
<body>
<%
   Users users2 = (Users)request.getAttribute("users");

if(users2!=null){

%>
<div id="form">
			<!--  http://127.0.0.1:8080/proj_servlet_0904/reg.do -->
				<form action="user.do?opt=upd" method="post" id="registForm">
					<div id="father">
						<div id="form2">
							<table border="0px" width="100%" height="100%" align="center" cellpadding="0px" cellspacing="0px" bgcolor="white">
								<tr>
									<td colspan="2" >
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<font size="5">会员修改</font>&nbsp;&nbsp;&nbsp;USER UPDATE
									</td>
								</tr>
								<tr>
									<td width="180px">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<label for="user" >用户ID</label>
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="user_id" size="35px" id="user_id" readonly="readonly" value="<%=users2.getUser_id() %>" />
									</td>
								</tr>
								<tr>
									<td width="180px">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										<label for="user" >用户名</label>
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="user_name" size="35px" id="user_name"  value="<%=users2.getUser_name()%>"/>
									</td>
								</tr>
								
								
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										年龄
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="user_age" size="35px" id="user_age" value="<%=users2.getUser_age()%>"/>
									</td>
								</tr>
								
								<tr>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;
										体重
									</td>
									<td>
										<em style="color: red;">*</em>&nbsp;&nbsp;&nbsp;<input type="text" name="user_weight"  size="35px" id="user_weight" value="<%=users2.getUser_weight()%>"/>
									</td>
								</tr>
								
								<tr>
									<td colspan="2">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="submit" value="修     改 " height="50px"/>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</form>
			</div>
<%} %>
</body>
</html>