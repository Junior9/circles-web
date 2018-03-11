package com.eg.circles.circles_web.model;

public class Manager {
	
	private int id;
	private String login;
	private String password;
	private Boolean isAdm;
	
	Manager(){}
	
	public Manager(String login,String password){
		this.login = login;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public Boolean getIsAdm() {
		return isAdm;
	}

}
