package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.Trucks;

public interface TrucksService {

	List<Trucks> getAllTrucks();
	
	void saveTruck(Trucks truck);
	
	Trucks getTruck(int id);
	
	void deleteTruck(int id);
	
	Page<Trucks> getTrucksForDatatable(String queryString, Pageable pageable);
}
