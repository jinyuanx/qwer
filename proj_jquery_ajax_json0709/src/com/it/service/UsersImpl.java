package com.it.service;

import java.util.List;

import com.it.bean.Users;
import com.it.dao.UsersDAO;


/**
 * 
 * 
* <p>
 * Title:
 *  UsersImpl 依赖dao层
 *
 * </p>
 * <p>
 * Description:com.it.service.UsersImpl.java
 * </p>
 * <p>
 * Copyright: Copyright (c) j2se 8.0
 * </p>
 * <p>
 * date: 2018年8月16日 下午5:57:58
 * </p>
 * <p>
 * Company: gy
 * </p>
 * 
 * @author zxy
 */

public class UsersImpl implements IUsers {
	UsersDAO    dao  =  new UsersDAO();

	/* (non-Javadoc)
	 * @see com.it.service.IUsers#addUsers(com.it.bean.Users)
	 */
	@Override
	public boolean addUsers(Users users) {
		
		return  dao.addUsers(users);
	}

	/* (non-Javadoc)
	 * @see com.it.service.IUsers#delUsers(com.it.bean.Users)
	 */
	@Override
	public boolean delUsers(Users users) {
		// TODO Auto-generated method stub
		return dao.delUsers(users);
	}

	/* (non-Javadoc)
	 * @see com.it.service.IUsers#updUsers(com.it.bean.Users)
	 */
	@Override
	public boolean updUsers(Users users) {
		// TODO Auto-generated method stub
		return dao.updUsers(users);
	}

	/* (non-Javadoc)
	 * @see com.it.service.IUsers#queryAllUsers(com.it.bean.Users)
	 */
	@Override
	public List<Users> queryAllUsers(Users users) {
		// TODO Auto-generated method stub
		return dao.queryAllUsers(users);
	}

	/* (non-Javadoc)
	 * @see com.it.service.IUsers#findUsersById(com.it.bean.Users)
	 */
	@Override
	public Users findUsersById(Users users) {
		// TODO Auto-generated method stub
		return dao.findUsersById(users);
	}

}
