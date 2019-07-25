/**
 * 
 * 
* <p>
 * Title:
 * 
 *
 * </p>
 * <p>
 * Description:com.it.service.IProvService.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018年8月20日 下午3:32:27
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

/**
 * @author Administrator
 *
 */
public interface IProvService {
	public void addProv(Prov prov);
	public void updProv(Prov prov);
	public void delProv(Prov prov);
	public List<Prov> queryAll(Prov prov);
	public Prov findById(Prov prov);
}
