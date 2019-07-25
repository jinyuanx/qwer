package com.it.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.it.bean.Prov;
import com.it.service.IProvService;
import com.it.service.ProvServiceImpl;

/**
 * Servlet implementation class ProvServlet
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/ProvServlet", 
				"/prov.do"
		})
public class ProvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvServlet() {
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
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//生成对象
		 Prov prov = new Prov();
		 //servie
		 IProvService iProvService =  new ProvServiceImpl();
		 //执行
		 List<Prov> listP = iProvService.queryAll(prov);
		 
		 //生成jsonArray
		 JSONArray array = JSONArray.fromObject(listP);
		 //传值给前台
		 System.out.println("jsonArray-->"+array.toString());
		 
		out.print(array.toString());
		// out.print(array );
	}

}
