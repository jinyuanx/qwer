package com.it.service;

import java.util.List;

import com.it.bean.Users;

/**
 * 
 * 
* <p>
 * Title:
 * 
 *方法，规则
 *
 * </p>
 * <p>
 * Description:com.it.service.IUsers.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018年8月16日 下午5:55:54
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */

public interface IUsers {
	//增
	public boolean addUsers(Users users);
	//删
	public boolean delUsers(Users users);
	//改
	public boolean updUsers(Users users);
	//查
	public List<Users> queryAllUsers(Users users);
	//查
	public Users findUsersById(Users users);
	
	

}
