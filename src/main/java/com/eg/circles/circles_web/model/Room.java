package com.eg.circles.circles_web.model;

import java.util.Calendar;

public class Room {
	
	private int id;
	private Calendar timeDate;
	private Course course;
	private String tenant;

	public int getId() {
		return id;
	}
	public Calendar getTimeDate() {
		return timeDate;
	}
	public Course getCourse() {
		return course;
	}
	public String getTenant() {
		return tenant;
	}
}
