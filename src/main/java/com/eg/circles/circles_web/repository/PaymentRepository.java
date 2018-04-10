package com.eg.circles.circles_web.repository;

import org.springframework.data.repository.CrudRepository;

import com.eg.circles.circles_web.model.Course;
import com.eg.circles.circles_web.model.Customer;
import com.eg.circles.circles_web.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, String> {
	
	Payment findById(int id);
	
	Payment findByCustomerAndCourse(Customer customer,Course course);
}