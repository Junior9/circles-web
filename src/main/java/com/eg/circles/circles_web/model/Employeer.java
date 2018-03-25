package com.eg.circles.circles_web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeer")
public class Employeer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int department;
	private String email;
	private String phoneNumber;
	//Have case where the employeer don't hava salary
	private int isPay;

	Employeer(){}
	
	public int getId() {
		return id;
	}
	public int getDepartment() {
		return department;	
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public int getIsPay() {
		return isPay;
	}
	public String getName() {
		return name;
	}
}