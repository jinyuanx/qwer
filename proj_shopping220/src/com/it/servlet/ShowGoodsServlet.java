package com.it.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.GoodsInfo;
import com.it.data.GoodData;

/**
 * Servlet implementation class ShowGoodsServlet
 */
@WebServlet({ "/ShowGoodsServlet", "/show.do" })
public class ShowGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodsServlet() {
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
		
		//设置编码格式
		response.setCharacterEncoding("utf-8");
		
		//集合
		List<GoodsInfo> goodsInfo = GoodData.goodsInfo;
		//存储数据
		request.setAttribute("goodsInfo", goodsInfo);
		//转发
		request.getRequestDispatcher("goods/showGoods.jsp").forward(request, response);
		
		
	}

}
