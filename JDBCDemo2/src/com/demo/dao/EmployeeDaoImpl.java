package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static Connection con;
	private static PreparedStatement psins,psdel,psupdate,psget,psgetById,pssorted;
	
	static {
		
		try {
			con=DBUtil.getMyConnection();
			
			psins=con.prepareStatement("insert into j2emp(empno,ename,sal,deptno) values(?,?,?,100)");
			psdel=con.prepareStatement("delete from j2emp where empno=?");
			psupdate=con.prepareStatement("update j2emp set sal=? where empno=?");
			psget=con.prepareStatement("select * from j2emp");
			psgetById=con.prepareStatement("select * from j2emp where empno=?");
			pssorted=con.prepareStatement("select * from j2emp order by sal");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(Employee e) {
		try {
			psins.setInt(1, e.getEmpid());
			psins.setString(2, e.getEname());
			psins.setInt(3, e.getSal());
			psins.executeUpdate();
			System.out.println("Employee added");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			psdel.setInt(1, id);
			int n=psdel.executeUpdate();
			return n>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBySal(int id, int newsal) { 
		try {
			psupdate.setInt(1, newsal);
			psupdate.setInt(2, id);
			int n=psupdate.executeUpdate();
			return n>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
			List<Employee> lst = new ArrayList<>();
			ResultSet rs=psget.executeQuery();
			while(rs.next()) {
				lst.add(new Employee(rs.getInt(1),rs.getString(2),rs.getInt("sal")));
			}
			return lst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getById(int id) {
		try {
			psgetById.setInt(1, id);
			ResultSet rs=psgetById.executeQuery();
			while(rs.next()) {
				return new Employee(rs.getInt(1), rs.getString(2), rs.getInt("sal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getSorted() {
		try {
			List<Employee> lst= new ArrayList<>();
			ResultSet rs=pssorted.executeQuery();
			while(rs.next()) {
				lst.add(new Employee(rs.getInt(1),rs.getString(2),rs.getInt("sal")));
			}
			return lst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeMyConnection() {
		DBUtil.closeMyConnection();
	}
}
