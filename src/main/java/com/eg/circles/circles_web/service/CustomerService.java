package com.eg.circles.circles_web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Customer;
import com.eg.circles.circles_web.model.Payment;
import com.eg.circles.circles_web.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Iterable<Customer> getAll() {
		return  customerRepository.findAll();
	}

	public Customer get(int id) {
		return customerRepository.findById(id);
	}

	public Customer save(Customer customer) {
//		if (customer.getId() == 0 ) {
//			customer.setPayments(getEmpetyListPayment());
//		}
		return customerRepository.save(customer);
	}

	private List<Payment> getEmpetyListPayment() {
		List<Payment> payment = new ArrayList<Payment>(12);
		
		for(int index = 0; index < 12; index++) {
			payment.add(new Payment(false));
		}	
		return payment;
	}

	public void delete(int idCustomer) {
		customerRepository.delete(String.valueOf(idCustomer));
	}

	public Boolean Paypayment(int id, int month) {
		Customer customer =  customerRepository.findById(id);
		customer.getPayments()[month] = 1;
		customerRepository.save(customer);
		return customer != null;
	}

	public boolean CleanPaypayment(int id, int month) {
		Customer customer =  customerRepository.findById(id);
		customer.getPayments()[month] = 0;
		customerRepository.save(customer);
		return customer != null;
	}
}
