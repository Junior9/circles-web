package com.eg.circles.circles_web.model.eto;

import java.util.ArrayList;
import java.util.List;

public class MonthAccountingETO {
	
	private List<Double> series;

	public MonthAccountingETO() {
		this.series = new ArrayList<Double>();
	}
	
	public List<Double> getSeries() {
		return series;
	}

	public void setSeries(List<Double> series) {
		this.series = series;
	}
}
