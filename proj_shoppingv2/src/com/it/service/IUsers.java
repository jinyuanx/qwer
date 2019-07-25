package com.it.service;

import java.util.List;

import com.it.bean.Users;

/**
 * 
 * Title:
 * Description:com.it.service.IUsers.java
 * Copyright: Copyright (c) j2se zxySoft
 * Company: zxySoft
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
	//登录
	public boolean login(Users users);

}
