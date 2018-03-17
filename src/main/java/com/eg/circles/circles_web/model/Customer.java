package com.eg.circles.circles_web.model;

public class Customer {
	
	private int id;
	private String name;
	private String email;
	private int level;
	private String phoneNumber;
	private Double payment;
	private String feedback;
	private Course course;
	private String studing;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getLevel() {
		return level;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public Double getPayment() {
		return payment;
	}
	public String getFeedback() {
		return feedback;
	}
	public Course getCourse() {
		return course;
	}
	public String getStuding() {
		return studing;
	}
}
