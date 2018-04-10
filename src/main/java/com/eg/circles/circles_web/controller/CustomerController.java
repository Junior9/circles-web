package com.eg.circles.circles_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eg.circles.circles_web.model.Customer;
import com.eg.circles.circles_web.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/all")
	public Iterable<Customer> getAll() {
		return customerService.getAll();
	}
	
	@GetMapping("/customer/{id}")
	public Customer get(@PathVariable int id) {
		return customerService.get(id);
	}
	
	@GetMapping("/customer/pay/{id}/{month}")
	public void payPayment(@PathVariable int id,@PathVariable int month) {
		if (customerService.Paypayment(id,month)){
			//return "Payment successs";
		}
		//return "Failed payment";
	}
	
	@GetMapping("/customer/pay/clean/{id}/{month}")
	public void cleanPayment(@PathVariable int id,@PathVariable int month) {
		if (customerService.CleanPaypayment(id,month)){
			//return "Payment successs";
		}
		//return "Failed payment";
	}

	@PostMapping(value="/customer/save",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	@DeleteMapping("/customer/delete")
	public void delete(@PathVariable int idCustomer) {
		customerService.delete(idCustomer);
	}
}