package com.sjsu.cmpe272.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageYearStorage {
	@JsonProperty
	private long yearAvgStorage;
	
	@JsonProperty
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getYearAvgStorage() {
		return yearAvgStorage;
	}
	public void setYearAvgStorage(long yearAvgStorage) {
		this.yearAvgStorage = yearAvgStorage;
	}
	
}
