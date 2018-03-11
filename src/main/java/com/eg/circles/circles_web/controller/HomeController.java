package com.eg.circles.circles_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eg.circles.circles_web.model.Manager;
import com.eg.circles.circles_web.service.ManagerService;

@RestController
public class HomeController {
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/")
	public ModelAndView home(){
		return new ModelAndView("index");
	}
	
	@GetMapping("/login")
	public Manager login(Manager manager) {
		return managerService.login(manager);
	}
}