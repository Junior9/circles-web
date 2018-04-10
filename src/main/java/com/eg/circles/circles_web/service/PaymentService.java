package com.eg.circles.circles_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Course;
import com.eg.circles.circles_web.model.Customer;
import com.eg.circles.circles_web.model.Payment;
import com.eg.circles.circles_web.repository.CourseRepository;
import com.eg.circles.circles_web.repository.CustomerRepository;
import com.eg.circles.circles_web.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepoitory;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public Payment get(int id, int idCourse) {
		Customer customer = customerRepository.findById(id);
		Course course = courseRepository.findById(idCourse);

		return paymentRepoitory.findByCustomerAndCourse(customer, course);
	}
	
	
	
}
