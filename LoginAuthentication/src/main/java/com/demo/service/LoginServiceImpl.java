package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

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

	@Override
	public int addRegisterUser(RegisterUser ru, MyUser mu) {
		return loginDao.registerUser(ru,mu);
	}
	
	
}
