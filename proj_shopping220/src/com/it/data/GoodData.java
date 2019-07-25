package com.it.data;

import java.util.ArrayList;
import java.util.List;

import com.it.bean.GoodsInfo;

/**
 * 
 * Title:模拟数据库表
 * Description:com.it.data.GoodData.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */
public class GoodData {
	
	public static List<GoodsInfo> goodsInfo= new ArrayList<GoodsInfo>();
	
	static{
		
		goodsInfo.add(new GoodsInfo("gd001", "笔记本电脑", "7000"));
		goodsInfo.add(new GoodsInfo("gd002", "大豫竹", "1"));
		goodsInfo.add(new GoodsInfo("gd003", "辣条", "4"));
		goodsInfo.add(new GoodsInfo("gd004", "华为手机p20", "8000"));
		goodsInfo.add(new GoodsInfo("gd005", "三星手机", "4000"));
		
		
	}
	
	
	//包含一个通过编号得到商品对象的方法
	
	public static GoodsInfo getGoodsInfo(String goods_Id){
		
		for (GoodsInfo goodsInfo2 : goodsInfo) {
			
			if(goodsInfo2.getGoods_Id().equals(goods_Id)){
				
				return goodsInfo2;
			}
		}
		
		return null;
	}
	

}
