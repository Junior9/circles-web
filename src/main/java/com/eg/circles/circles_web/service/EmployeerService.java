package com.eg.circles.circles_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Employeer;
import com.eg.circles.circles_web.repository.EmployeerRepository;

@Service
public class EmployeerService {
	
	@Autowired
	private EmployeerRepository employeerRepository;

	public Iterable<Employeer> getAll() {
		return employeerRepository.findAll();
	}

	public Employeer get(int idEmployeer) {
		return null;
	}

	public Employeer save(Employeer employeer) {
		return employeerRepository.save(employeer);
	}

	public void delete(int idEmployeer) {
		// TODO Auto-generated method stub
	}
}