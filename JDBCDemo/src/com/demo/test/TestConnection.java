package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) {
		// step 1: Register the driver
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			// step 2: Create connection
			String url = "jdbc:mysql://192.168.10.150:3306/dac41";
			Connection con = DriverManager.getConnection(url, "dac41", "welcome");
			if (con != null) {
				System.out.println("connection done\n");
			} else {
				System.out.println("connection not done\n");
			}

			// step 3: Create statement
			Statement st = con.createStatement();

			// step 4: Execute query
			ResultSet rs = st.executeQuery("select * from emp");
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString("ename"));
				System.out.println("Salary: " + rs.getInt(7));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
