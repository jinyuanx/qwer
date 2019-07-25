package com.it.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Users;
import com.it.service.IUsers;
import com.it.service.UsersImpl;
import com.it.utils.StringUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/user.do" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1 设置编码格式
		request.setCharacterEncoding("utf-8");
		// 2 获取页面信息
		String opt = request.getParameter("opt");
		String user_id = request.getParameter("user_id");
		String user_age = request.getParameter("user_age");
		String user_weight = request.getParameter("user_weight");
		String user_name = request.getParameter("user_name");
		PrintWriter out = response.getWriter();
		// 3 生成对象
		Users users = new Users();
		// 4 service
		IUsers iUsers = new UsersImpl();
		//5 存放集合内容
		List<Users> listU = null;	

		// 判断执行的功能
		//reg
				if("reg".equals(opt)){
					// "" null
					
							
					if (StringUtil.isNotEmpty(user_age)) {

						users.setUser_age(Integer.parseInt(user_age));

					}
					if (StringUtil.isNotEmpty(user_name)) {

						users.setUser_name(user_name);

					}
					
					if (StringUtil.isNotEmpty(user_weight)) {

						users.setUser_weight(Double.parseDouble(user_weight));

					}
					
					boolean flag = iUsers.addUsers(users);
					
					out.print(flag);
					
					
				}
		//修改
		if("upd".equals(opt)){
			// "" null
			
						if (StringUtil.isNotEmpty(user_id)) {

							users.setUser_id(Integer.parseInt(user_id));

						}
			if (StringUtil.isNotEmpty(user_age)) {

				users.setUser_age(Integer.parseInt(user_age));

			}
			if (StringUtil.isNotEmpty(user_name)) {

				users.setUser_name(user_name);

			}
			
			if (StringUtil.isNotEmpty(user_weight)) {

				users.setUser_weight(Double.parseDouble(user_weight));

			}
			
			iUsers.updUsers(users);
			response.sendRedirect("user.do?opt=queryAll");
			
			
			return;
		}
		//查询单个
		/*if("findById".equals(opt)){
			// "" null
			
			if (StringUtil.isNotEmpty(user_id)) {

				users.setUser_id(Integer.parseInt(user_id));

			}
			Users users2 = iUsers.findUsersById(users);
			
			if(users2!=null){
				
				
				request.setAttribute("users", users2);
				//转发
				request.getRequestDispatcher("users/findById.jsp").forward(request, response);
				
			}
			
			return;
		}*/
		
		String flag = "1";//可用
		if("findById".equals(opt)){
			// "" null
			
			if (StringUtil.isNotEmpty(user_id)) {

				users.setUser_id(Integer.parseInt(user_id));

			}
			Users users2 = iUsers.findUsersById(users);
			
			if(users2!=null){
				flag = "-1";
						
			}
			System.out.println("flag-->"+flag);
			out.print(flag);
			
			
		}
		//查询所有
		if("queryAll".equals(opt)){
			if (StringUtil.isNotEmpty(user_age)) {

				users.setUser_age(Integer.parseInt(user_age));

			}
			if (StringUtil.isNotEmpty(user_name)) {

				users.setUser_name(user_name);

			}
			
			listU = iUsers.queryAllUsers(users);
			//把对象存储到request中
			request.setAttribute("listU", listU);
			//跳转--》转发
			request.getRequestDispatcher("users/queryAll.jsp").forward(request, response);
			
			
			return;
		}
		// 登录
		if ("login".equals(opt)) {
			// 5 "" null

			if (StringUtil.isNotEmpty(user_id)) {

				users.setUser_id(Integer.parseInt(user_id));

			}
			if (StringUtil.isNotEmpty(user_age)) {

				users.setUser_age(Integer.parseInt(user_age));

			}
			// 6 执行
			boolean flag1 = iUsers.login(users);
			System.out.println(String.valueOf(flag1));
			out.print(String.valueOf(flag1));
			/*if (flag1) {
				response.sendRedirect("user.do?opt=queryAll");
			} else {
				response.sendRedirect("login.html");
			}

			return;*/
		}
	}

}
