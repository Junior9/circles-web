package com.eg.circles.circles_web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "course",uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToOne()
	private Employeer employeer;
	//private List <Calendar> timeDate;
	
	@OneToMany(cascade = {CascadeType.REMOVE})
	private List <Customer> customes;
	private int level;

	Course(){}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Employeer getEmployeer() {
		return employeer;
	}
//	public List<Calendar> getTimeDate() {
//		return timeDate;
//	}
	public List<Customer> getCustomes() {
		return customes;
	}
	public int getLevel() {
		return level;
	}
}