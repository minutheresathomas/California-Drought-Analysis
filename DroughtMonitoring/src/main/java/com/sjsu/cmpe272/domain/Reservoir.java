package com.sjsu.cmpe272.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservoir {
	@JsonProperty
	private String stationId;
	@JsonProperty
	private String stationName;
	@JsonProperty
	private String county;
	@JsonProperty
	private String dataCollection;
	@JsonProperty
	private String operator;
	@JsonProperty
	private String longitude;
	@JsonProperty
	private String latitude;
	@JsonProperty
	private String nearbyCity;
	@JsonProperty
	private String hydrologicArea;
	@JsonProperty
	private Object riverBasin;
	@JsonProperty
	private String elevation;
	@JsonProperty
	private Map<String, Long> storageData;
	@JsonProperty
	private Map<String, Long> inflowData;
	@JsonProperty
	private Map<String, Long> outflowData;
	@JsonProperty
	List<AverageMonthStorage> avgMonthStore = new ArrayList<AverageMonthStorage>();
	@JsonProperty
	List<AverageYearStorage> avgYearStore = new ArrayList<AverageYearStorage>();
	@JsonProperty
	List<AverageMonthInflow> avgMonthInflow = new ArrayList<AverageMonthInflow>();
	@JsonProperty
	List<AverageYearInflow> avgYearInflow = new ArrayList<AverageYearInflow>();
	@JsonProperty
	List<AverageMonthOutflow> avgMonthOutflow = new ArrayList<AverageMonthOutflow>();
	@JsonProperty
	List<AverageYearOutflow> avgYearOutflow = new ArrayList<AverageYearOutflow>();
	
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDataCollection() {
		return dataCollection;
	}
	public void setDataCollection(String dataCollection) {
		this.dataCollection = dataCollection;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getNearbyCity() {
		return nearbyCity;
	}
	public void setNearbyCity(String nearbyCity) {
		this.nearbyCity = nearbyCity;
	}
	public String getHydrologicArea() {
		return hydrologicArea;
	}
	public void setHydrologicArea(String hydrologicArea) {
		this.hydrologicArea = hydrologicArea;
	}
	public Object getRiverBasin() {
		return riverBasin;
	}
	public void setRiverBasin(Object riverBasin) {
		this.riverBasin = riverBasin;
	}
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
//	public Map<Long, Long> getStorageData() {
//		return storageData;
//	}
//	public void setStorageData(Map<Long, Long> storageData) {
//		this.storageData = storageData;
//	}
	
	public Map<String, Long> getStorageData() {
		return storageData;
	}
	public void setStorageData(Map<String, Long> storageData) throws ParseException {
		this.storageData = storageData;
		List<AverageMonthStorage> avgMonthStore1 = new ArrayList<AverageMonthStorage>();
		List<AverageYearStorage> avgYearStore1 = new ArrayList<AverageYearStorage>();
		Iterator<String> it = storageData.keySet().iterator();
		long monthTotal = 0;
		long yearTotal = 0;
		long num_days = 0;
		long num_month = 0;
		int mon = -1;
		int yr = 0;
		long monthAvg = 0;
		long yearAvg = 0;
//		String 
		while(it.hasNext())
		{
			AverageMonthStorage monthStore = new AverageMonthStorage();
			AverageYearStorage yearStore = new AverageYearStorage();
			String key = it.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			date = format.parse(key);
			System.out.println("####################################");
			System.out.println("Date is from set : "+date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			// to get previous date
			
			if(mon == month || mon == -1)
			{
				monthTotal = monthTotal+storageData.get(key);
				System.out.println("mon value is ;"+storageData.get(key));
				num_days++;
			}
			else if(mon != month)
			{
				if(num_days !=0)
					monthAvg = monthTotal/num_days;
				monthStore.setMonthAvgStorage(monthAvg);
				cal.add(Calendar.DATE, -1);
				monthStore.setDate(format.format(cal.getTime()));
				avgMonthStore1.add(monthStore);
//				setAvgMonthStore(avgMonthStore1);
				monthTotal = 0;
				num_days = 0;
				mon = -1;
				monthAvg = 0;
			}
			mon = month;
			if(yr == year || yr == 0)
			{
				yearTotal = yearTotal + storageData.get(key);
				num_month++;
			}
			else if(yr != year)
			{
				if(num_month != 0)
					yearAvg = yearTotal/num_month;
				cal.add(Calendar.DATE, -1);
				yearStore.setDate(format.format(cal.getTime()));
				yearStore.setYearAvgStorage(yearAvg);
				avgYearStore1.add(yearStore);
//				setAvgYearStore(avgYearStore1);
				yearTotal = 0;
				num_month = 0;
				yr = 0;
				yearAvg = 0;
			}
			yr = year;
		}
		setAvgMonthStore(avgMonthStore1);
		setAvgYearStore(avgYearStore1);
	}
	public Map<String, Long> getInflowData() {
		return inflowData;
	}
	public void setInflowData(Map<String, Long> inflowData) throws ParseException {
		
		this.inflowData = inflowData;
		List<AverageMonthInflow> avgMonthInflow1 = new ArrayList<AverageMonthInflow>();
		List<AverageYearInflow> avgYearInflow1 = new ArrayList<AverageYearInflow>();
		Iterator<String> it = inflowData.keySet().iterator();
		long monthTotal = 0;
		long yearTotal = 0;
		long num_days = 0;
		long num_month = 0;
		int mon = -1;
		int yr = 0;
		long monthAvg = 0;
		long yearAvg = 0;
		while(it.hasNext())
		{
			AverageMonthInflow monthInflow = new AverageMonthInflow();
			AverageYearInflow yearInflow = new AverageYearInflow();
			String key = it.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			date = format.parse(key);
			System.out.println("####################################");
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			System.out.println("Month is : "+month);
			int year = cal.get(Calendar.YEAR);
			System.out.println("year is : "+year);
			if(mon == month || mon == -1)
			{
				monthTotal = monthTotal+inflowData.get(key);
				System.out.println("mon value is ;"+inflowData.get(key));
				num_days++;
			}
			else if(mon != month)
			{
				if(num_days !=0)
					monthAvg = monthTotal/num_days;
				System.out.println("num_days is : "+num_days);
				cal.add(Calendar.DATE, -1);
				monthInflow.setMonthAvgInflow(monthAvg);
				monthInflow.setDate(format.format(cal.getTime()));
				avgMonthInflow1.add(monthInflow);
//				setAvgMonthInflow(avgMonthInflow1);
				monthTotal = 0;
				num_days = 0;
				mon = -1;
				monthAvg = 0;
			}
			mon = month;
			if(yr == year || yr == 0)
			{
				yearTotal = yearTotal + inflowData.get(key);
				num_month++;
			}
			else if(yr != year)
			{
				if(num_month != 0)
					yearAvg = yearTotal/num_month;
				cal.add(Calendar.DATE, -1);
				yearInflow.setDate(format.format(cal.getTime()));
				yearInflow.setYearAvgInflow(yearAvg);
				avgYearInflow1.add(yearInflow);
//				setAvgYearInflow(avgYearInflow1);
				yearTotal = 0;
				num_month = 0;
				yr = 0;
				yearAvg = 0;
			}
			yr = year;
		}
		setAvgMonthInflow(avgMonthInflow1);
		setAvgYearInflow(avgYearInflow1);
	}
	public Map<String, Long> getOutflowData() {
		return outflowData;
	}
	public void setOutflowData(Map<String, Long> outflowData) throws ParseException {
		this.outflowData = outflowData;
		List<AverageMonthOutflow> avgMonthOutflow1 = new ArrayList<AverageMonthOutflow>();
		List<AverageYearOutflow> avgYearOutflow1 = new ArrayList<AverageYearOutflow>();
		Iterator<String> it = outflowData.keySet().iterator();
		long monthTotal = 0;
		long yearTotal = 0;
		long num_days = 0;
		long num_month = 0;
		int mon = -1;
		int yr = 0;
		long monthAvg = 0;
		long yearAvg = 0;
		while(it.hasNext())
		{
			AverageMonthOutflow monthOutflow = new AverageMonthOutflow();
			AverageYearOutflow yearOutflow = new AverageYearOutflow();
			String key = it.next();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date;
			date = format.parse(key);
			System.out.println("####################################");
			System.out.println("Date is from set : "+date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			System.out.println("Month is : "+month);
			int year = cal.get(Calendar.YEAR);
			System.out.println("year is : "+year);
			if(mon == month || mon == -1)
			{
				monthTotal = monthTotal+outflowData.get(key);
				System.out.println("mon value is ;"+outflowData.get(key));
				num_days++;
			}
			else if(mon != month)
			{
				if(num_days !=0)
					monthAvg = monthTotal/num_days;
				System.out.println("num_days is : "+num_days);
				cal.add(Calendar.DATE, -1);
				monthOutflow.setMonthAvgOutflow(monthAvg);
				monthOutflow.setDate(format.format(cal.getTime()));
				avgMonthOutflow1.add(monthOutflow);
//				setAvgMonthOutflow(avgMonthOutflow1);
				monthTotal = 0;
				num_days = 0;
				mon = -1;
				monthAvg = 0;
				
			}
			mon = month;
			if(yr == year || yr == 0)
			{
				yearTotal = yearTotal + outflowData.get(key);
				num_month++;
			}
			else if(yr != year)
			{
				if(num_month != 0)
					yearAvg = yearTotal/num_month;
				cal.add(Calendar.DATE, -1);
				yearOutflow.setDate(format.format(cal.getTime()));
				yearOutflow.setYearAvgOutflow(yearAvg);
				avgYearOutflow1.add(yearOutflow);
//				setAvgYearOutflow(avgYearOutflow1);
				yearTotal = 0;
				num_month = 0;
				yr = 0;
				yearAvg = 0;
			}
			yr = year;
		}
		setAvgMonthOutflow(avgMonthOutflow1);
		setAvgYearOutflow(avgYearOutflow1);
	}
	public List<AverageMonthStorage> getAvgMonthStore() {
		return avgMonthStore;
	}
	public void setAvgMonthStore(List<AverageMonthStorage> avgMonthStore) {
		this.avgMonthStore = avgMonthStore;
	}
	public List<AverageYearStorage> getAvgYearStore() {
		return avgYearStore;
	}
	public void setAvgYearStore(List<AverageYearStorage> avgYearStore) {
		this.avgYearStore = avgYearStore;
	}
	public List<AverageMonthInflow> getAvgMonthInflow() {
		return avgMonthInflow;
	}
	public void setAvgMonthInflow(List<AverageMonthInflow> avgMonthInflow) {
		this.avgMonthInflow = avgMonthInflow;
	}
	public List<AverageYearInflow> getAvgYearInflow() {
		return avgYearInflow;
	}
	public void setAvgYearInflow(List<AverageYearInflow> avgYearInflow) {
		this.avgYearInflow = avgYearInflow;
	}
	public List<AverageMonthOutflow> getAvgMonthOutflow() {
		return avgMonthOutflow;
	}
	public void setAvgMonthOutflow(List<AverageMonthOutflow> avgMonthOutflow) {
		this.avgMonthOutflow = avgMonthOutflow;
	}
	public List<AverageYearOutflow> getAvgYearOutflow() {
		return avgYearOutflow;
	}
	public void setAvgYearOutflow(List<AverageYearOutflow> avgYearOutflow) {
		this.avgYearOutflow = avgYearOutflow;
	}
	
}
