package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.dao.LoginDao;

public class LoginServiceImpl implements LoginService {
	private LoginDao loginDao;

	public LoginServiceImpl() {
		super();
		this.loginDao = new LoginDaoImpl();
	}

	@Override
	public MyUser validateUser(String uname, String passwd) {
		return loginDao.authenticateUser(uname,passwd);
	}
	
	
}
