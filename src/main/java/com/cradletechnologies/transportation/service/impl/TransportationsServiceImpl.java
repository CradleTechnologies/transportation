package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.filter.TransportationsDataFilter;
import com.cradletechnologies.transportation.model.Transportations;
import com.cradletechnologies.transportation.repository.TransportationsRepository;
import com.cradletechnologies.transportation.service.TransportationsService;

@Service
public class TransportationsServiceImpl implements TransportationsService{

	@Autowired
	private TransportationsRepository transportationsRepository;

	@Override
	public List<Transportations> getAllTransportations() {
		return this.transportationsRepository.findAll();
	}

	@Override
	public Transportations saveTransportation(Transportations transportation) {
		return this.transportationsRepository.save(transportation);
		
	}

	@Override
	public Transportations getTransportation(int id) {
		Optional<Transportations> optional = transportationsRepository.findById(id);
		Transportations transportation = null;
		if(optional.isPresent()) {
			transportation = optional.get();
		}
		else {
			throw new RuntimeException("Location not found for id : "+id);
		}
		return transportation;
	}


	@Override
	public void deleteTransportation(int id) {
		this.transportationsRepository.deleteById(id);
		
	}

	@Override
	public Page<Transportations> getTransportationsForDatatable(String queryString, Pageable pageable) {
		TransportationsDataFilter transportationsDataFilter = new TransportationsDataFilter(queryString);
		return transportationsRepository.findAll(transportationsDataFilter, pageable);
	}
	
	

}
