package com.demo.beans;

public class Team {
	private int tid;
	private String tname;
	private Player p;
	
	public Team() {
		super();
	}
	
	public Team(int tid, String tname, Player p) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.p = p;
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
	public Player getP() {
		return p;
	}
	public void setP(Player p) {
		this.p = p;
	}
	
	@Override
	public String toString() {
		return "Team [tid=" + tid + ", tname=" + tname + ", p=" + p + "]";
	}
}
