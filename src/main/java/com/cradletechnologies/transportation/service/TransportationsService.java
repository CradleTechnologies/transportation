package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.Transportations;

public interface TransportationsService {
	
	List<Transportations> getAllTransportations();
	
	Transportations saveTransportation(Transportations transportation);
	
	Transportations getTransportation(int id);
	
	void deleteTransportation(int id);
	
	Page<Transportations> getTransportationsForDatatable(String queryString, Pageable pageable);

}
