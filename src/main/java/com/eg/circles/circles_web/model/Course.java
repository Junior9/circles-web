package com.eg.circles.circles_web.model;

import java.util.Calendar;
import java.util.List;

public class Course {
	
	private int id;
	private String name;
	private Employeer employeer;
	private List <Calendar> timeDate;
	private List <Customer> customes;
	private int level;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Employeer getEmployeer() {
		return employeer;
	}
	public List<Calendar> getTimeDate() {
		return timeDate;
	}
	public List<Customer> getCustomes() {
		return customes;
	}
	public int getLevel() {
		return level;
	}
}
