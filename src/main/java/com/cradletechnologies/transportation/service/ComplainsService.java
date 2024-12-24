package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.Complains;

public interface ComplainsService {

	List<Complains> getAllComplains();
	
	void saveComplain(Complains complain);
	
	Complains getComplain(int id);
	
	void deleteComplain(int id);
	
	Page<Complains> getComplainsForDatatable(String queryString, Pageable pageable);
}
