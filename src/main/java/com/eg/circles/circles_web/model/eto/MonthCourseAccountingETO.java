package com.eg.circles.circles_web.model.eto;

public class MonthCourseAccountingETO {
	
	private static final int MONTHS = 12;
	private String name;
	private Double[] data;
	
	public MonthCourseAccountingETO(String name) {
		this.name = name;
		this.data = new Double[MONTHS];
		initData();
	}

	private void initData() {
		for(int month=0;month < MONTHS ; month++) {
			this.data[month] = 0.0;	
		}
	}

	public String getName() {
		return name;
	}

	public Double[] getData() {
		return data;
	}

	public void add(Double payment, Integer[] payments) {
		for(int month=0;month < MONTHS ; month++) {
			if(payments[month] != null && payments[month] == 1) {
				this.data[month] += payment;
			}
		}
	}
}
