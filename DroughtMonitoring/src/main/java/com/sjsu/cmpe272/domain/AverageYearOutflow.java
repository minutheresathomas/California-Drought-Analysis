package com.sjsu.cmpe272.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageYearOutflow {

	@JsonProperty
	private long yearAvgOutflow;
	
	@JsonProperty
	private String date;

	public long getYearAvgOutflow() {
		return yearAvgOutflow;
	}

	public void setYearAvgOutflow(long yearAvgOutflow) {
		this.yearAvgOutflow = yearAvgOutflow;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
