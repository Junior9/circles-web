package com.eg.circles.circles_web.service;

import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Manager;
import com.eg.circles.circles_web.repository.ManagerRepository;

@Service
public class ManagerService {

	private ManagerRepository managerRepository;
	
	public Manager login(Manager manager) {
		manager = managerRepository.login(manager);
		if(manager == null){
			manager = new Manager("","");
		}
		return manager;
	}
}
