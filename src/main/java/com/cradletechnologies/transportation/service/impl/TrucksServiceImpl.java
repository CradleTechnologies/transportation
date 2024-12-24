package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.filter.TrucksDataFilter;
import com.cradletechnologies.transportation.model.Trucks;
import com.cradletechnologies.transportation.repository.TrucksRepository;
import com.cradletechnologies.transportation.service.TrucksService;

@Service
public class TrucksServiceImpl implements TrucksService{

	@Autowired
	private TrucksRepository trucksRepository;

	@Override
	public List<Trucks> getAllTrucks() {
		return this.trucksRepository.findAll();
	}

	@Override
	public void saveTruck(Trucks truck) {
		this.trucksRepository.save(truck);
		
	}

	@Override
	public Trucks getTruck(int id) {
		Optional<Trucks> optional = trucksRepository.findById(id);
		Trucks truck = null;
		if(optional.isPresent()) {
			truck = optional.get();
		}
		else {
			throw new RuntimeException("Truck not found for id : "+id);
		}
		return truck;
	}


	@Override
	public void deleteTruck(int id) {
		this.trucksRepository.deleteById(id);
		
	}

	@Override
	public Page<Trucks> getTrucksForDatatable(String queryString, Pageable pageable) {
		TrucksDataFilter trucksDataFilter = new TrucksDataFilter(queryString);
		return trucksRepository.findAll(trucksDataFilter, pageable);
	}
	
	

}
