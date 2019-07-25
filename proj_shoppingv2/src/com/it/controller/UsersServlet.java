package com.it.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.Users;
import com.it.service.IUsers;
import com.it.service.UsersImpl;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet({ "/UsersServlet", "/user.do", "/user" })
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        //  1 设置编码格式
		   request.setCharacterEncoding("utf-8");
		   //2获取页面信息
		      //  2-1 获取opt
		   String opt = request.getParameter("opt");
		     // 2-2获取值 注册，修改
		   String user_name = request.getParameter("user_name");
		   String user_age = request.getParameter("user_age");
		   String user_weight = request.getParameter("user_weight");
		   //登录
		   String user_id = request.getParameter("user_id");
		  //  3 生成对象
		   Users users = new Users();
		  //  4 service
		   IUsers iUsers = new UsersImpl();
		    //结果返回
		   
		   boolean flag = false;
		   //存放结果集
		   List<Users> listU = null;
		   //服务器端进行会话跟踪
		   //生成session
		   HttpSession session = request.getSession();
		   
		  // 5 根据opt的值进行判断执行特定的功能
		   //修改
		   if("upd".equals(opt)){
			   //"" null js
			   users.setUser_id(Integer.parseInt(user_id));
			   users.setUser_name(user_name);
			   users.setUser_age(Integer.parseInt(user_age));
			   users.setUser_weight(Double.parseDouble(user_weight));
			  //2  执行修改
			   flag = iUsers.updUsers(users);
			   
			   //ok
			    if(flag){
			    	response.sendRedirect("user.do?opt=queryAll");
			    }
			    else{
			    	response.sendRedirect("error.html");
			    }
			   
			   return;
		   }
		   //查询单个
		   if("findById".equals(opt)){
			   
			   //赋值
			   //1 赋值
			   users.setUser_id(Integer.parseInt(user_id));
			   //2 执行查询单个
			   Users users2 = iUsers.findUsersById(users);
			   //根据结果进行跳转
			   /**
			    * user.do---->users2--->findById.jsp--->把Users2展示出来
			    * 
			    * 两个组件共享同一个对象
			    * 转发跳转
			    * 先存值
			    * 再跳转
			    * 
			    */
			   if(users2!=null){
				   //存值
				   request.setAttribute("users", users2);
				   //跳转
				   request.getRequestDispatcher("/users/findById.jsp").forward(request, response);
				   
			   }
			   
			   
			   return;
		   }
		   //查询所有
		   if("queryAll".equals(opt)){
			   //模糊查询
			  // "" null
			   if (!"".equals(user_name) && user_name != null) {
					users.setUser_name(user_name);
				}
				if (!"".equals(user_age) && user_age != null) {
					users.setUser_age(Integer.parseInt(user_age));
				}
			   
			   //查询所有
			   listU = iUsers.queryAllUsers(users);
			   //
			   /**展示出来
			    * View--->queryAllUsers.jsp
			    * jsp中展示的listU这个集合对象中的所有内容
			    * user.do--->servlet
			    * queryAllUsers.jsp--->jsp
			    * 
			    * 连个web组件之间要共享数据listU
			    * listU将从 user.do---》到queryAllUsers.jsp--》之后仍然是个对象
			    */
			   //把对象存入request中
			   request.setAttribute("listU", listU);
			     //跳转
			     //请求转发
			   request.getRequestDispatcher("users/queryAllUsers.jsp").forward(request, response);
			   
			     
			   
			   return;
		   }
		   //登录
		   if("login".equals(opt)){
			   
			   //1 赋值
			   users.setUser_id(Integer.parseInt(user_id));
			   users.setUser_age(Integer.parseInt(user_age));
			   //2 执行登录
			   flag =  iUsers.login(users);
			
			 //ok
		    if(flag){
		    	//首页--》展示所有信息--》queryAll.do
		    	//user.do?opt=queryAll
		    	//response.sendRedirect("index.html");
		    	
		    	//response.sendRedirect("user.do?opt=queryAll");
		    	//保存值
		    	session.setAttribute("users", users);
		    	response.sendRedirect("index.jsp");
		    }
		    else{
		    	response.sendRedirect("users/login.html");
		    }
			   return;
		   }
		   //注册
		   if("reg".equals(opt)){
			   
			   //1 赋值
			   
			   users.setUser_name(user_name);
			   users.setUser_age(Integer.parseInt(user_age));
			   users.setUser_weight(Double.parseDouble(user_weight));
			   
			   //2 执行添加功能
			   flag = iUsers.addUsers(users);
			   //ok
			    if(flag){
			    	response.sendRedirect("users/login.html");
			    }
			    else{
			    	response.sendRedirect("error.html");
			    }
			   return;
		   }
		
	}

}
