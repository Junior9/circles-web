package com.eg.circles.circles_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.circles.circles_web.model.eto.CourseAccountingETO;
import com.eg.circles.circles_web.model.eto.MonthAccountingETO;
import com.eg.circles.circles_web.model.eto.MonthCourseAccountingETO;
import com.eg.circles.circles_web.service.CourseService;

@RestController
public class AccountingController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/accounting/all/course")
	public CourseAccountingETO allProfitPerCourse(){
		CourseAccountingETO coursesAccounting =  courseService.getAllProfithAllCourse();
		return coursesAccounting;
	}	
	
	
	@GetMapping("/accounting/all/months")
	public MonthAccountingETO allProfitPerMonth(){
		MonthAccountingETO coursesAccounting =  courseService.getAllProfithAllMonth();
		return coursesAccounting;
	}	
	
	@GetMapping("accounting/all/months/courses")
	public List<MonthCourseAccountingETO> allProfitPerMonthCourse(){
		List<MonthCourseAccountingETO> coursesMonthAccounting =  courseService.getAllProfithAllMonthCourse();
		return coursesMonthAccounting;
	}
	
	
}
