package com.it.bean;

/**
 * 
 * 
* <p>
 * Title:
 * 
 *
 * </p>
 * <p>
 * Description:com.it.bean.Prov.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018年8月20日 下午3:32:35
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */

public class Prov {
	private String prov_id;
	private String prov_name;
	
	/**
	 * @return the prov_id
	 */
	public String getProv_id() {
		return prov_id;
	}
	/**
	 * @param prov_id the prov_id to set
	 */
	public void setProv_id(String prov_id) {
		this.prov_id = prov_id;
	}
	/**
	 * @return the prov_name
	 */
	public String getProv_name() {
		return prov_name;
	}
	/**
	 * @param prov_name the prov_name to set
	 */
	public void setProv_name(String prov_name) {
		this.prov_name = prov_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.prov_id+"\t"+this.prov_name;
	}
	/**
	 * 
	 */
	public Prov() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param prov_id
	 * @param prov_name
	 */
	public Prov(String prov_id, String prov_name) {
		super();
		this.prov_id = prov_id;
		this.prov_name = prov_name;
	}
	
}
