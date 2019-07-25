package com.it.bean;

import java.io.Serializable;

/**
 * 
 * 
* <p>
 * Title:
 * 
 *
 * </p>
 * <p>
 * Description:com.it.bean.City.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018年8月20日 下午3:32:21
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */

public class City implements Serializable {
	 private String city_id;
	 private String city_name;
	 private String prov_id;
	 /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.city_id+"\t"+this.city_name+"\t"+this.prov_id ;
	}
	/**
	 * 
	 */
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param city_id
	 * @param city_name
	 * @param prov_id
	 */
	public City(String city_id, String city_name, String prov_id) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.prov_id = prov_id;
	}
	/**
	 * @return the city_id
	 */
	public String getCity_id() {
		return city_id;
	}
	/**
	 * @param city_id the city_id to set
	 */
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	/**
	 * @return the city_name
	 */
	public String getCity_name() {
		return city_name;
	}
	/**
	 * @param city_name the city_name to set
	 */
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
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
	
}
