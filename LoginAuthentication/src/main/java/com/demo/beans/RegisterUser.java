package com.demo.beans;

import java.time.LocalDate;
import java.util.Arrays;

public class RegisterUser {
	private int uid;
	private String name;
	private String addr;
	private String uname;
	private String[] skills;
	private String gender;
	private LocalDate dt;
	private String city;
	
	public RegisterUser() {
		super();
	}
	
	public RegisterUser(int uid, String name, String addr, String uname, String[] skills, String gender, LocalDate dt,
			String city) {
		super();
		this.uid = uid;
		this.name = name;
		this.addr = addr;
		this.uname = uname;
		this.skills = skills;
		this.gender = gender;
		this.dt = dt;
		this.city = city;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDt() {
		return dt;
	}
	public void setDt(LocalDate dt) {
		this.dt = dt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "RegisterUser [uid=" + uid + ", name=" + name + ", addr=" + addr + ", uname=" + uname + ", skills="
				+ Arrays.toString(skills) + ", gender=" + gender + ", dt=" + dt + ", city=" + city + "]";
	}
	
}
