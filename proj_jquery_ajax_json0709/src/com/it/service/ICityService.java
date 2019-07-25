/**
 * 
 * 
* <p>
 * Title:
 * 
 *
 * </p>
 * <p>
 * Description:com.it.service.ICityService.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018年8月20日 下午3:40:21
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */
package com.it.service;

import java.util.List;

import com.it.bean.City;
import com.it.bean.Prov;

/**
 * @author Administrator
 *
 */
public interface ICityService {
	public void addCity(City city);
	public void updCity(City city);
	public void delCity(City city);
	public List<City> queryAll(City city);
	public City findById(City city);
	public List<City> queryCitysByProvId(Prov prov);
}
