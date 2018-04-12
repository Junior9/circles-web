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
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Iterable<Customer> getAll() {
		return  customerRepository.findAll();
	}

	public Customer get(int id) {
		return customerRepository.findById(id);
	}

	public Customer save(Customer customerForm) {
		Customer customer = null;
		if (customerForm.getId() == 0) {
			customer = customerRepository.save(customerForm);
			Payment payment =  new Payment(customer, customer.getCourse(),customer.getPayment() );
			paymentRepository.save(payment);		
			return customer;
		}else {

			//customer = customerRepository.findById(customer.getId());
			
			customer = customerRepository.save(customerForm);
			Payment payment =  paymentRepository.findByCustomerAndCourse(customer, customer.getCourse());
			
			if(customer.getPayment() != payment.getPayment()) {
				payment.setPayment(customer.getPayment());
				paymentRepository.save(payment);
			}
			return customer;
		}
	}

	public void delete(int idCustomer) {
		customerRepository.delete(String.valueOf(idCustomer));
	}

	public Boolean Paypayment(int id, int idCourse, int month) {
		Customer customer =  customerRepository.findById(id);
		Course course =  courseRepository.findById(idCourse);
		Payment payment = paymentRepository.findByCustomerAndCourse(customer, course);
		payment.getPayments()[month] = 1;
		return paymentRepository.save(payment) != null;
	}
	
	public Boolean CleanPayment(int id, int idCourse, int month) {
		Customer customer =  customerRepository.findById(id);
		Course course =  courseRepository.findById(idCourse);
		Payment payment = paymentRepository.findByCustomerAndCourse(customer, course);
		payment.getPayments()[month] = 0;
		return paymentRepository.save(payment) != null;
	}
}