package com.it.controller;

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
import com.it.dao.GoodsData;
import com.it.service.CarService;
import com.it.service.GoodsImpl;
import com.it.service.IGoods;

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
		 String goods_Id = request.getParameter("goods_Id");
		 String opt = request.getParameter("opt");
		 String count = request.getParameter("count");
		 //3 生成对象
		 GoodsInfo goodsInfo = new GoodsInfo();
		 //生成session
		 HttpSession session = request.getSession();
		
			//查询所有商品
			
			IGoods igoods = new GoodsImpl();
		 //获取购物车
		 /**
		  * 1 第一次添加商品
		  * 2 其它次添加商品
		  */
		 if(session.getAttribute("car")==null){
			 
			 //生成session放个车
			 session.setAttribute("car", new ArrayList<GoodsDetails>());
			 
		 }
		 //获取购物车
		 
		 List<GoodsDetails> car = (List<GoodsDetails>)session.getAttribute("car");
		 
		 //给购物车关联一个业务
		 
		 CarService carService = new CarService(car);
		 //判断功能
		 //清空购物车
		 if("cls".equals(opt)){
			 carService.cls();
			//跳转--》showCar.jsp
			 response.sendRedirect("car/showCar.jsp");
			// response.sendRedirect("showGoods");
			 return;
		 }
		 //修改功能
		 if("upd".equals(opt)){
			 int cnt = 0;
			// "",null
			 if(!"".equals(goods_Id) && goods_Id!=null){
			     goodsInfo.setGoods_Id(goods_Id);
			 }
			 if(!"".equals(count) && count!=null){
			     cnt = Integer.parseInt(count);
			 }
			 
			 //修改功能
			 carService.upd2Car(goodsInfo, cnt);
			 
			//跳转--》showCar.jsp
			 response.sendRedirect("car/showCar.jsp");
			 return;
		 }
		 //删除功能
		 if("del".equals(opt)){
			 //"" null
			 if(!"".equals(goods_Id) && goods_Id!=null){
			     goodsInfo.setGoods_Id(goods_Id);
			 }
			 //执行删除功能
			 carService.del2Car(goodsInfo);
			 //跳转--》showCar.jsp
			 response.sendRedirect("car/showCar.jsp");
			 return;
		 }
		 //添加商品
		 if("buy".equals(opt)){
			 //查找到商品
			 //"" null
			 if(!"".equals(goods_Id) && goods_Id!=null){
			     goodsInfo.setGoods_Id(goods_Id);
			 }
			 //GoodsInfo goodsInfo1 = igoods.findGoodsById(goodsInfo);
			 GoodsInfo goodsInfo1 = GoodsData.findById(goodsInfo);
			 //默认情况下商品数量为1
			 
			 //执行添加功能
			 carService.add2Car(goodsInfo1, 1);
			 //跳转--》showCar.jsp
			 response.sendRedirect("car/showCar.jsp");
			 
			 return;
		 }
		 
	}

}
