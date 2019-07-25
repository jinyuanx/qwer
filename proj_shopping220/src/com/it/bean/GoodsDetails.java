package com.it.bean;
/**
 * 
 * Title:ÉÌÆ·Ã÷Ï¸
 * Description:com.it.bean.GoodsDetails.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
 * @author zxy
 */
public class GoodsDetails {
	private GoodsInfo goodsInfo;
	private int count;
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public GoodsDetails(GoodsInfo goodsInfo, int count) {
		super();
		this.goodsInfo = goodsInfo;
		this.count = count;
	}
	public GoodsDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GoodsDetails [goodsInfo=" + goodsInfo + ", count=" + count
				+ "]";
	}
	

}
