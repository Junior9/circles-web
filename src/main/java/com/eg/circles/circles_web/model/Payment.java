package com.eg.circles.circles_web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "payment",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne()
	private Customer customer;
	@OneToOne()
	private Course course;
	private Double payment;
	private Integer[] payments;
	private Double totalPay;
	
	public Payment() {
		payments = new Integer[12];
	}
	
	public Payment(Customer customer, Course course,Double payment) {
		this.course = course;
		this.customer = customer;
		this.payment = payment;
		payments = new Integer[12];
	}
	public Double getPay() {
		return totalPay;
	}
	public void addPay() {
		this.totalPay += payment;
	}
	public void removePay() {
		this.totalPay -= payment;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Course getCourse() {
		return course;
	}
	public Integer[] getPayments() {
		return payments;
	}
	public void setPayments(Integer[] payments ) {
		this.payments = payments;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
}