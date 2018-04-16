package com.eg.circles.circles_web.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Calendar timeDate;
	private String course;
	private String tenant;
	private Double value;

	public int getId() {
		return id;
	}
	public Calendar getTimeDate() {
		return timeDate;
	}
	public String getCourse() {
		return course;
	}
	public String getTenant() {
		return tenant;
	}
	public Double getValue() {
		return value;
	}
}
