package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class TestPreparedStatement {

	public static void main(String[] args) {
		Connection con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			String url = "jdbc:mysql://192.168.10.150:3306/dac41?useSSL=false";
			con = DriverManager.getConnection(url, "dac41", "welcome");
			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement("select * from j2emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Id: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Salary: " + rs.getInt("sal"));
				System.out.println();
			}

			int id = 1000;
			String name = "HITMAN";
			int sal = 100000;
			int deptno = 10;
			PreparedStatement ps2 = con.prepareStatement("insert into j2emp(empno,ename,sal,deptno) values(?,?,?,?)");
			ps2.setInt(1, id);
			ps2.setString(2, name);
			ps2.setInt(3, sal);
			ps2.setInt(4, deptno);
			int num = ps2.executeUpdate();
			if (num > 0) {
				System.out.println("inserted");
				con.commit();
			} else {
				System.out.println("not inserted");
				con.rollback();
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("duplicate entry");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
