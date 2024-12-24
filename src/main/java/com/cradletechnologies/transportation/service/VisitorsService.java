package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.model.Visitors;
import com.cradletechnologies.transportation.repository.VisitorsRepository;

@Service
public class VisitorsService {

	@Autowired
	private VisitorsRepository repository;

	public Visitors saveVisitorInfo(Visitors visitor) {
		return repository.save(visitor);
	}
	
	public List<Visitors> getAllVisits(){
		return repository.findAll();
	}

}