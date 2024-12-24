package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.Areas;

public interface AreasService {

	List<Areas> getAllAreas();
	
	void saveArea(Areas area);
	
	Areas getArea(int id);
	
	void deleteArea(int id);
	
	Page<Areas> getAreasForDatatable(String queryString, Pageable pageable);
}
