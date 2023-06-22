package com.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;
import com.demo.dao.DBUtil;
import com.demo.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {
	private static Connection conn;
	private static PreparedStatement pst;
	static {
		conn = DBUtil.getMyConnection();
		try {
			pst = conn.prepareStatement("select * from user where uname=? and password=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MyUser authenticateUser(String uname, String passwd) {
		try {
			pst.setString(1, uname);
			pst.setString(2, passwd);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new MyUser(uname, passwd, rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
