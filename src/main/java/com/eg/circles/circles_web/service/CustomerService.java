package com.eg.circles.circles_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Customer;
import com.eg.circles.circles_web.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Iterable<Customer> getAll() {
		return  customerRepository.findAll();
	}

	public Customer get(int idCustomer) {
		return customerRepository.findOne(String.valueOf(idCustomer));
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public void delete(int idCustomer) {
		customerRepository.delete(String.valueOf(idCustomer));
	}
}
