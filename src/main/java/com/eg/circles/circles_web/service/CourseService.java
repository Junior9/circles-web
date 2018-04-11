package com.eg.circles.circles_web.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.circles.circles_web.model.Course;
import com.eg.circles.circles_web.model.CourseAccounting;
import com.eg.circles.circles_web.model.Employeer;
import com.eg.circles.circles_web.model.Payment;
import com.eg.circles.circles_web.model.eto.CourseAccountingETO;
import com.eg.circles.circles_web.model.eto.CourseETO;
import com.eg.circles.circles_web.model.eto.MonthAccountingETO;
import com.eg.circles.circles_web.model.eto.MonthCourseAccountingETO;
import com.eg.circles.circles_web.repository.CourseRepository;
import com.eg.circles.circles_web.repository.EmployeerRepository;
import com.eg.circles.circles_web.repository.PaymentRepository;

@Service
public class CourseService {
	
	private static final int MONTHS = 12;

	private static final Double ZERO = 0.0;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private EmployeerRepository employeerRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
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

	public CourseAccountingETO getAllProfithAllCourse() {
		Map<String,CourseAccounting> mapCourse =  new LinkedHashMap<String, CourseAccounting>();
		CourseAccountingETO courseAccountingETO = new CourseAccountingETO(); 
		Iterable<Payment> payments = paymentRepository.findByYear( String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		CourseAccounting courseAccountingAux;
		for (Payment payment : payments) {
			if(mapCourse.containsKey(payment.getCourse().getName())) {
				courseAccountingAux= mapCourse.get(payment.getCourse().getName());
				courseAccountingAux.add(payment.getPayment());
				mapCourse.put(payment.getCourse().getName(), courseAccountingAux);
			}else {
				courseAccountingAux = new CourseAccounting(payment.getCourse().getName());
				courseAccountingAux.add(payment.getPayment());
				mapCourse.put(payment.getCourse().getName(), courseAccountingAux);
			}
		}
		
		for (String key : mapCourse.keySet()) {
			courseAccountingETO.getCategore().add( mapCourse.get(key).getName());
			courseAccountingETO.getSeries().add( mapCourse.get(key).getTotal());
		}
		return courseAccountingETO;
	}

	public MonthAccountingETO getAllProfithAllMonth() {
		Map<Integer,Double> mapMonth =  startMapMonth();
		MonthAccountingETO  monthAccountingETO = new MonthAccountingETO();
		Iterable<Payment> payments = paymentRepository.findByYear( String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		
		for (Payment payment : payments) {
			for (int index = 0; index < payment.getPayments().length; index++ ) {
				if(payment.getPayments()[index] != null && payment.getPayments()[index] == 1 ) {
					Double valueMonth = payment.getPayment();
					Double totalMonth = mapMonth.get(index);
					totalMonth += valueMonth;
					mapMonth.put(index, totalMonth);
				}
			}
			payment.getPayments();
		}
		
		for (Integer key : mapMonth.keySet()) {
			monthAccountingETO.getSeries().add(mapMonth.get(key));
		}
		
		return monthAccountingETO;
	}

	private Map<Integer, Double> startMapMonth() {
		LinkedHashMap<Integer, Double> map = new LinkedHashMap<Integer, Double>();
		for (int index = 0; index < MONTHS; index++ ) {
			map.put(index, ZERO);
		}
		return map;
	}

	public List<MonthCourseAccountingETO> getAllProfithAllMonthCourse() {
		Map<String,MonthCourseAccountingETO> mapMonthCourse =  new LinkedHashMap<String, MonthCourseAccountingETO>();
		Iterable<Payment> payments = paymentRepository.findByYear( String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		
		MonthCourseAccountingETO monthCourseAccountingAux;
		List<MonthCourseAccountingETO> listMonthCourseAccounting = new ArrayList<MonthCourseAccountingETO>();
		
		for (Payment payment : payments) {
			if(mapMonthCourse.containsKey(payment.getCourse().getName())) {
				monthCourseAccountingAux= mapMonthCourse.get(payment.getCourse().getName());
				monthCourseAccountingAux.add(payment.getPayment(),payment.getPayments());
				mapMonthCourse.put(payment.getCourse().getName(), monthCourseAccountingAux);
			}else {
				monthCourseAccountingAux = new MonthCourseAccountingETO(payment.getCourse().getName());
				monthCourseAccountingAux.add(payment.getPayment(),payment.getPayments());
				mapMonthCourse.put(payment.getCourse().getName(), monthCourseAccountingAux);
			}
		}
		
		for (String key : mapMonthCourse.keySet()) {
			listMonthCourseAccounting.add(mapMonthCourse.get(key));
		}
		
		return listMonthCourseAccounting;
	}

}
