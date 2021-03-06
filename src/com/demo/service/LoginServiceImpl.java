package com.demo.service;

import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
    private LoginDao loginDao;
    
	public LoginServiceImpl() {
		super();
		this.loginDao = new LoginDaoImpl();
	}

	@Override
	public String validateUser(String uname, String pass) {
		return loginDao.ValidateUser(uname,pass);
	}

}
