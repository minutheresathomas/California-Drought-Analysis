package com.sjsu.cmpe272.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageYearInflow {

	@JsonProperty
	private long yearAvgInflow;
	
	@JsonProperty
	private String date;

	public long getYearAvgInflow() {
		return yearAvgInflow;
	}

	public void setYearAvgInflow(long yearAvgInflow) {
		this.yearAvgInflow = yearAvgInflow;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
