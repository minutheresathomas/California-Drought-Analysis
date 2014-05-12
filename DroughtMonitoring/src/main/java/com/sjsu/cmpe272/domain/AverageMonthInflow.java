package com.sjsu.cmpe272.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageMonthInflow {
	@JsonProperty
	private long monthAvgInflow;
	
	@JsonProperty
	private String date;

	public long getMonthAvgInflow() {
		return monthAvgInflow;
	}

	public void setMonthAvgInflow(long monthAvgInflow) {
		this.monthAvgInflow = monthAvgInflow;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
