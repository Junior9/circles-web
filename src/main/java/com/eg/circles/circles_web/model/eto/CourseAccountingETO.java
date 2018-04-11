package com.eg.circles.circles_web.model.eto;

import java.util.ArrayList;
import java.util.List;

public class CourseAccountingETO {
	
	private List<String> categore;
	private List<Double> series;
	
	public CourseAccountingETO() {
		this.categore = new ArrayList<String>();
		this.series = new ArrayList<Double>();
	}
	
	public List<String> getCategore() {
		return categore;
	}
	public void setCategore(List<String> categore) {
		this.categore = categore;
	}
	public List<Double> getSeries() {
		return series;
	}
	public void setSeries(List<Double> series) {
		this.series = series;
	}
}