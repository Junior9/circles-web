package com.eg.circles.circles_web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Course;
import com.eg.circles.circles_web.repository.CourseRepository;

@Service
public class CourseService {
	
//	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourse() {
		return null;
	}

	public Course get(int idCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	public Course save(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int idCourse) {
		// TODO Auto-generated method stub
	}

}
