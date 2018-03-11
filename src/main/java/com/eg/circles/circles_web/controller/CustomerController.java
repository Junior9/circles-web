package com.eg.circles.circles_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.circles.circles_web.model.Customer;
import com.eg.circles.circles_web.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/all")
	public List<Customer> getAll() {
		return customerService.getAll();
	}
	
	@GetMapping("/customer/{idCustomer}")
	public Customer get(@PathVariable int idCustomer) {
		return customerService.get(idCustomer);
	}
	
	@PostMapping("/customer/save")
	public Customer save(Customer customer) {
		return customerService.save(customer);
	}

	@DeleteMapping("/customer/delete")
	public void delete(@PathVariable int idCustomer) {
		customerService.delete(idCustomer);
	}
}