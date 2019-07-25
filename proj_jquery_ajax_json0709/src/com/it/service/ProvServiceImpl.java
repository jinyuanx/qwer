/**
 * 
 * 
* <p>
 * Title:
 * 
 *
 * </p>
 * <p>
 * Description:com.it.service.ProvServiceImpl.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018年8月20日 下午3:35:27
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */
package com.it.service;

import java.util.List;

import com.it.bean.Prov;

import com.it.dao.ProvDAO;

/**
 * @author Administrator
 *
 */
public class ProvServiceImpl implements IProvService {

	ProvDAO dao = new ProvDAO();
	/* (non-Javadoc)
	 * @see com.it.service.ProvService#addProv(com.it.bean.Prov)
	 */
	@Override
	public void addProv(Prov prov) {
		 dao.addProv(prov);
	}

	/* (non-Javadoc)
	 * @see com.it.service.ProvService#updProv(com.it.bean.Prov)
	 */
	@Override
	public void updProv(Prov prov) {
		dao.updProv(prov);

	}

	/* (non-Javadoc)
	 * @see com.it.service.ProvService#delProv(com.it.bean.Prov)
	 */
	@Override
	public void delProv(Prov prov) {
		dao.delProv(prov);

	}

	/* (non-Javadoc)
	 * @see com.it.service.ProvService#queryAll(com.it.bean.Prov)
	 */
	@Override
	public List<Prov> queryAll(Prov prov) {
		
		return dao.queryAll(prov);
	}

	/* (non-Javadoc)
	 * @see com.it.service.ProvService#findById(com.it.bean.Prov)
	 */
	@Override
	public Prov findById(Prov prov) {
		
		return dao.findById(prov);
	}

}
