package com.demo.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestCallable {

	public static void main(String[] args) {
		Connection con;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			String url = "jdbc:mysql://192.168.10.150:3306/dac41?useSSL=false";
			con = DriverManager.getConnection(url, "dac41", "welcome");
			if (con != null) {
				System.out.println("connection done");
			} else {
				System.out.println("connection not done");
			}

			CallableStatement cs = con.prepareCall("call getcnt(?,?)");
			cs.setInt(1, 20);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			cs.execute();
			int c = cs.getInt(2);
			System.out.println("No. of employees: " + c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;

	}

}

//mysql cmd
/*
delimiter $$
procedure getcnt(in dno int, out cnt int)
begin
select count(*) into cnt
from emp
where deptno=dno;
end$$
*/

//call getcnt(10,@c);
//$$

//select @c;
//$$