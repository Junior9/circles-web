package com.eg.circles.circles_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.circles.circles_web.model.Course;
import com.eg.circles.circles_web.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/course/all")
	public List<Course> getAll() {
		return courseService.getAllCourse();
	}
	
	@GetMapping("/course/{idCourse}")
	public Course get(@PathVariable int idCourse) {
		return courseService.get(idCourse);
	}
	
	@PostMapping("/course/save")
	public Course save(Course course) {
		return courseService.save(course);
	}

	@DeleteMapping("/course/delete/{idCourse}")
	public void delete(@PathVariable int idCourse) {
		courseService.delete(idCourse);
	}
}
