package com.demo.beans;

import java.util.List;

public class Team {
	private int tid;
	private String tname;
	private List<Player> plist;
	
	public Team() {
		super();
	}
	
	public Team(int tid, String tname, List<Player> plist) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.plist = plist;
	}
	
	public int getTid() {
		return tid;
	}
	
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getTname() {
		return tname;
	}
	
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public List<Player> getPlist() {
		return plist;
	}

	public void setPlist(List<Player> plist) {
		this.plist = plist;
	}

	@Override
	public String toString() {
		return "Team [tid=" + tid + ", tname=" + tname + ", plist=" + plist + "]";
	}
	
}
