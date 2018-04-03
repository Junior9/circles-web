package com.eg.circles.circles_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Course;
import com.eg.circles.circles_web.model.Employeer;
import com.eg.circles.circles_web.model.eto.CourseETO;
import com.eg.circles.circles_web.repository.CourseRepository;
import com.eg.circles.circles_web.repository.EmployeerRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private EmployeerRepository employeerRepository;
	
	
	public Iterable<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	public Course get(int id) {
		return courseRepository.findById(id);
	}

	public Course save(CourseETO courseEto) {
		Employeer employeer = employeerRepository.findOne(String.valueOf(courseEto.getIdEmploye()));
		return courseRepository.save(new Course(courseEto.getName(),employeer));
	}

	public Course save(Course course) {
		return courseRepository.save(course);
	}
	
	
	public void delete(int idCourse) {
		// TODO Auto-generated method stub
	}

}
