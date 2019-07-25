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

import com.it.bean.City;
import com.it.bean.Prov;
import com.it.service.CityServiceImpl;
import com.it.service.ICityService;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/CityServlet", 
				"/city.do"
		})
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
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
		
		
		
		//1 设置编码格式
		  request.setCharacterEncoding("utf-8");
		  response.setCharacterEncoding("utf-8");
		  PrintWriter out = response.getWriter();
		  //2 获取页面信息
		  String prov_id = request.getParameter("prov_id");
		  //3 生成对象
		  Prov prov = new Prov();
		    //“” null
		  prov.setProv_id(prov_id);
		  //3 service
		 ICityService  cityService = new CityServiceImpl();
		  //4 执行
		 List<City> listC = cityService.queryCitysByProvId(prov);
		 
		 //5 生成jsonArray
		 JSONArray array  = JSONArray.fromObject(listC);
		 System.out.println(array.toString());
		 out.print(array.toString());
	}

}
