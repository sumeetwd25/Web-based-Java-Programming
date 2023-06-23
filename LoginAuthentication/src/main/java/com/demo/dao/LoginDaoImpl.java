package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;

public class LoginDaoImpl implements LoginDao {
	private static Connection conn;
	private static PreparedStatement pst,psins,psuserins;
	static {
		conn = DBUtil.getMyConnection();
		try {
			pst = conn.prepareStatement("select * from user where uname=? and password=?");
			psins=conn.prepareStatement("insert into registeruser values(?,?,?,?,?,?,?,?)");
			psuserins=conn.prepareStatement("insert into user values(?,?,?)");
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

	@Override
	public int registerUser(RegisterUser ru, MyUser mu) {
		try {
			psins.setInt(1, ru.getUid());
			psins.setString(2, ru.getName());
			psins.setString(3, ru.getAddr());
			psins.setString(8, ru.getUname());
			psins.setString(5, ru.getSkills()[0]);
			psins.setString(4, ru.getGender());
			
			//to convert local date to sql date
			java.sql.Date dt = java.sql.Date.valueOf(ru.getDt()); 
			psins.setDate(6, dt);
			psins.setString(7, ru.getCity());
			psins.executeUpdate();
			
			psuserins.setString(1, mu.getUname());
			psuserins.setString(2, mu.getPasswd());
			psuserins.setString(3, mu.getRole());
			return psuserins.executeUpdate();
			
		} catch (SQLException e) {
					e.printStackTrace();
		}
		return 0;
	}

}
