package com.it.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Prov;
import com.it.service.IProvService;
import com.it.service.ProvServiceImpl;

/**
 * Servlet implementation class DelProv
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/DelProv", 
				"/prov2.do"
		})
public class DelProv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelProv() {
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
		
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String prov_id = request.getParameter("prov_id");
		
		Prov prov = new Prov();
		prov.setProv_id(prov_id);
		
		IProvService iProvService =  new ProvServiceImpl();
		
		String rs = "1";//Ö´ÐÐok
	     	try {
				iProvService.delProv(prov);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				   rs="0";
			}
	     	
	     	out.print(rs);
		
	}

}
