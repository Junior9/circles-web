package com.eg.circles.circles_web.model;

public class Employeer {
	
	private int id;
	private String department;
	private String email;
	private String phoneNumber;
	//Have case where the employeer don't hava salary
	private Boolean isPay;
 
	public int getId() {
		return id;
	}
	public String getDepartment() {
		return department;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public Boolean getIsPay() {
		return isPay;
	}
}
