package com.eg.circles.circles_web.model;

public class CourseAccounting {
	
	private String name;
	private int numStudiens;
	private Double total;

	public CourseAccounting() {
		this.total = 0.0;
	}
	public CourseAccounting(String name) {
		this.total = 0.0;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getNumStudiens() {
		return numStudiens;
	}
	public Double getTotal() {
		return total;
	}
	public void add(Double valor) {
		this.total += valor; 
	}
}
