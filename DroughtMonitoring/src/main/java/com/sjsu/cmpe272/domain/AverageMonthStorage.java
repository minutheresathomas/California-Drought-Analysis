package com.sjsu.cmpe272.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageMonthStorage {
	
	@JsonProperty
	private String date;
	
	@JsonProperty
	private long monthAvgStorage;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getMonthAvgStorage() {
		return monthAvgStorage;
	}
	public void setMonthAvgStorage(long monthAvgStorage) {
		this.monthAvgStorage = monthAvgStorage;
	}
	
}
