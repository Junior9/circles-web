package com.eg.circles.circles_web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Employeer;
import com.eg.circles.circles_web.repository.EmployeerRepository;

@Service
public class EmployeerService {
	
//	@Autowired
	private EmployeerRepository employeerRepository;

	public List<Employeer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employeer get(int idEmployeer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employeer save(Employeer employeer) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int idEmployeer) {
		// TODO Auto-generated method stub
	}
}