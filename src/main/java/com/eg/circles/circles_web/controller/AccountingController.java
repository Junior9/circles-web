package com.eg.circles.circles_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.circles.circles_web.model.Course;
import com.eg.circles.circles_web.service.CourseService;

@RestController
public class AccountingController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public List<Course> get(){
		return null;
	}	
	
	
}
