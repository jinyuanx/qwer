package com.it.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.GoodsDetails;
import com.it.bean.GoodsInfo;
import com.it.data.GoodData;
import com.it.service.CarService;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet({ "/BuyServlet", "/buy.do" })
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
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
		//2 获取页面信息
		String goods_Id =request.getParameter("goods_Id");
		String opt = request.getParameter("opt");
		String count = request.getParameter("count");
		//3 生成对象
		GoodsInfo goodsInfo = new GoodsInfo();
		
		//5 购物车
		List<GoodsDetails> car = null;
		//生成session
		
		HttpSession session = request.getSession();
		
		
		//是否是第一次购买商品
		
		if(session.getAttribute("car")==null){
			
			
			car = new ArrayList<GoodsDetails>();
			session.setAttribute("car", car);
		}
		//否则直接从session获取
				car = (List<GoodsDetails>)session.getAttribute("car");
		
		//4 //给车关联一个service
				CarService carService = new CarService(car);
				//清空购物车
				if("cls".equals(opt)){
					//执行
					carService.cls();
					//跳转
					response.sendRedirect("show.do");
					return;
				}
			//修改
			if("upd".equals(opt)){
				//"" null
				goodsInfo.setGoods_Id(goods_Id);
				//执行
				carService.upd2Car(goodsInfo, Integer.parseInt(count));
				//跳转
				response.sendRedirect("car/showCar.jsp");
				
				return;
			}
			//删除
				if("del".equals(opt)){
					
					//"" null
					goodsInfo.setGoods_Id(goods_Id);
					//执行
					carService.del2Car(goodsInfo);
					//跳转
					response.sendRedirect("car/showCar.jsp");
					
					return;
				}
				
				
		//buy
		if("buy".equals(opt)){
			
			GoodsInfo  goodsInfo2 = GoodData.getGoodsInfo(goods_Id);
			
			//执行
			carService.add2Car(goodsInfo2);
			
			//跳转
			response.sendRedirect("car/showCar.jsp");
		
			return;
		}
		
	}

}
