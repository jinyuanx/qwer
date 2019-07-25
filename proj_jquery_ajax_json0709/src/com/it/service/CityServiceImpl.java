/**
 * 
 * 
* <p>
 * Title:
 * 
 *
 * </p>
 * <p>
 * Description:com.it.service.CityServiceImpl.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018年8月20日 下午3:38:27
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
import com.it.dao.CityDAO;


/**
 * @author Administrator
 *
 */
public class CityServiceImpl implements ICityService {

	CityDAO dao = new CityDAO();
	/* (non-Javadoc)
	 * @see com.it.service.CityService#addCity(com.it.bean.City)
	 */
	@Override
	public void addCity(City city) {
		  dao.addCity(city);
	}

	/* (non-Javadoc)
	 * @see com.it.service.CityService#updCity(com.it.bean.City)
	 */
	@Override
	public void updCity(City city) {
		
        dao.updCity(city);

	}

	/* (non-Javadoc)
	 * @see com.it.service.CityService#delCity(com.it.bean.City)
	 */
	@Override
	public void delCity(City city) {
		
        dao.delCity(city);;

	}

	/* (non-Javadoc)
	 * @see com.it.service.CityService#queryAll(com.it.bean.City)
	 */
	@Override
	public List<City> queryAll(City city) {
		
		return dao.queryAll(city);
	}

	/* (non-Javadoc)
	 * @see com.it.service.CityService#findById(com.it.bean.City)
	 */
	@Override
	public City findById(City city) {
		
		return dao.findById(city);
	}

	@Override
	public List<City> queryCitysByProvId(Prov prov) {
		// TODO Auto-generated method stub
		return dao.queryCitysByProvId(prov);
	}
	

}
