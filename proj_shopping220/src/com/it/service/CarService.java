package com.it.service;

import java.util.List;

import com.it.bean.GoodsDetails;
import com.it.bean.GoodsInfo;

/**
 * 
 * Title:购物车的服务类 Description:com.it.service.CarService.java Copyright: Copyright
 * (c) j2se zxySoft Company: zxySoft
 * 
 * @author zxy
 */
public class CarService {

	List<GoodsDetails> car;

	public CarService(List<GoodsDetails> car) {
		super();
		this.car = car;
	}

	public CarService() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 添加指定商品到购物车
	/**
	 * 1 是否是第一次添加？ 是 直接添加 2 如果已经有了，修改数量
	 * 
	 * @param goodsInfo
	 */

	public void add2Car(GoodsInfo goodsInfo) {

		for (GoodsDetails goodsDetails : car) {
			// 1 如果已经有了，修改数量？判断编号一致，如果一直则修改数量
			if (goodsDetails.getGoodsInfo().getGoods_Id()
					.equals(goodsInfo.getGoods_Id())) {
				goodsDetails.setCount(goodsDetails.getCount() + 1);

				return;

			}
		}

		// 是第一次添加？

		car.add(new GoodsDetails(goodsInfo, 1));

	}

	// 删除指定商品

	public void del2Car(GoodsInfo goodsInfo) {

		for (GoodsDetails goodsDetails : car) {

			if (goodsDetails.getGoodsInfo().getGoods_Id()
					.equals(goodsInfo.getGoods_Id())) {

				car.remove(goodsDetails);
				return;
			}

		}

	}

	// 修改指定商品的数量

	public void upd2Car(GoodsInfo goodsInfo, int count) {

		for (GoodsDetails goodsDetails : car) {

			if (goodsDetails.getGoodsInfo().getGoods_Id()
					.equals(goodsInfo.getGoods_Id())) {

				goodsDetails.setCount(count);

			}
		}

	}
	// 清空购物车
	
	public void cls(){
		
		car.clear();
	}

}
