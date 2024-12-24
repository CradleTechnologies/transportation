package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.Designations;

public interface DesignationsService {

	List<Designations> getAllDesignations();
	
	void saveDesignation(Designations designation);
	
	Designations getDesignation(int id);
	
	void deleteDesignation(int id);
	
	Page<Designations> getDesignationsForDatatable(String queryString, Pageable pageable);
}
