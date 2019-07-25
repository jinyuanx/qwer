package com.it.bean;

import java.io.Serializable;

/**
 * <p>
 * Title:商品类
 * 
 *商品编号,商品名称，商品单价
 * </p>
 * Title:
 * Description:com.it.bean.GoodsInfo.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */
public class GoodsInfo implements Serializable {
	private String goods_Id;
	private String goods_Name;
	private String goods_Price;
	public String getGoods_Id() {
		return goods_Id;
	}
	public void setGoods_Id(String goods_Id) {
		this.goods_Id = goods_Id;
	}
	public String getGoods_Name() {
		return goods_Name;
	}
	public void setGoods_Name(String goods_Name) {
		this.goods_Name = goods_Name;
	}
	public String getGoods_Price() {
		return goods_Price;
	}
	public void setGoods_Price(String goods_Price) {
		this.goods_Price = goods_Price;
	}
	public GoodsInfo(String goods_Id, String goods_Name, String goods_Price) {
		super();
		this.goods_Id = goods_Id;
		this.goods_Name = goods_Name;
		this.goods_Price = goods_Price;
	}
	public GoodsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GoodsInfo [goods_Id=" + goods_Id + ", goods_Name=" + goods_Name
				+ ", goods_Price=" + goods_Price + "]";
	}
	
	
}
