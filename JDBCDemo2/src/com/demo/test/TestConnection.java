package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			String url = "jdbc:mysql://192.168.10.150:3306/dac41?useSSL=false";
			Connection con = DriverManager.getConnection(url, "dac41", "welcome");
			if (con != null) {
				System.out.println("connection done");
			} else {
				System.out.println("connection not done");
			}

			Statement st = con.createStatement();

			int id = 6001;
			String name = "gita";
			ResultSet rs = st.executeQuery("select * from j2emp where empno=" + id + " and ename='" + name + "'");
			while (rs.next()) {
				System.out.println("Employee id: " + rs.getInt(1));
				System.out.println("Employee name: " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
