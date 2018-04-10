package com.eg.circles.circles_web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")	
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private int level;
	private String phoneNumber;
	private Double payment;
	
	//@OneToMany
	private Integer[] payments;
	private String feedback;
	
	@OneToOne()
	private Course course;
	private int studing;
	
	Customer(){
		payments = new Integer[12];
	}

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
	public int getStuding() {
		return studing;
	}

	public Integer[] getPayments() {
		return payments;
	}
	
	public void setPayments(Integer[] payments ) {
		this.payments = payments;
	}	
}