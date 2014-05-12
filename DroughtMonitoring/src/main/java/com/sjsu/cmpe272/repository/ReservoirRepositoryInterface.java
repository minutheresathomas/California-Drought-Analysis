package com.sjsu.cmpe272.repository;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.sjsu.cmpe272.domain.Reservoir;

public interface ReservoirRepositoryInterface {
	public void insertReservoir(Reservoir reservoir);
	public List<Reservoir> getReservoirs() throws ParseException;
	public ConcurrentHashMap<String, Long> caPastThirtyDays() throws ParseException;
}
