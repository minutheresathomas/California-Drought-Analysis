package com.sjsu.cmpe272.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageMonthOutflow {
	@JsonProperty
	private long monthAvgOutflow;
	
	@JsonProperty
	private String date;

	public long getMonthAvgOutflow() {
		return monthAvgOutflow;
	}

	public void setMonthAvgOutflow(long monthAvgOutflow) {
		this.monthAvgOutflow = monthAvgOutflow;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
