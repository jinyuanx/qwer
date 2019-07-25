package com.it.service;

import java.util.List;

import com.it.bean.GoodsDetails;
import com.it.bean.GoodsInfo;

/**
 * 购物车
 * 
 * 操作车的一个类
 * Title:
 * Description:com.it.service.CarService.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */
public class CarService {

	List<GoodsDetails> car ;

	public List<GoodsDetails> getCar() {
		return car;
	}

	public void setCar(List<GoodsDetails> car) {
		this.car = car;
	}

	public CarService(List<GoodsDetails> car) {
		super();
		this.car = car;
	}

	public CarService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 //添加指定商品到购物车
	/**
	 * 1 循环迭代购物车
	 *   判断是否是第一次添加
	 *      a.如果不是，则修改数量
	 *      b.如果是，则新加到购物车
	 *      
	 */
	
	public void add2Car(GoodsInfo goodsInfo,int count){
		
		//循环迭代购物车
		
		for (GoodsDetails goodsDetails : car) {
			//已经购买过了
			 if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				 
				 //修改数量
				 goodsDetails.setCount(goodsDetails.getCount()+count);
				 return;
			 }
		}
		//第一次添加该商品
		
		car.add(new GoodsDetails(goodsInfo,count));
		
	}

	 //删除指定商品
	/**
	 *  1 循环迭代购物车
	 *   查询商品编号是否一致，如果一致则从车里移除
	 * @param goodsInfo
	 */
	public void del2Car(GoodsInfo goodsInfo){
		
		for (GoodsDetails goodsDetails : car) {
			 if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				 
				 car.remove(goodsDetails);
				 return;
			 }
			
		}
		
		
		
	}
	 //修改指定商品的数量
	/**
	 *  1 循环迭代购物车
	 *   
	 *     查询商品编号是否一致，如果一致则修改该商品的数量
	 * @param goodsInfo
	 * @param count
	 */
	
	public void upd2Car(GoodsInfo goodsInfo,int count){
		
		for (GoodsDetails goodsDetails : car) {
			 if(goodsDetails.getGoodsInfo().getGoods_Id().equals(goodsInfo.getGoods_Id())){
				 
				 goodsDetails.setCount(count);
				 return;
			 }
		}
		
		
	}
	
	 //清空购物车

	public void cls(){
		car.clear();
	}
}
