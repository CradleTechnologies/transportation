package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.filter.AreasDataFilter;
import com.cradletechnologies.transportation.model.Areas;
import com.cradletechnologies.transportation.repository.AreasRepository;
import com.cradletechnologies.transportation.service.AreasService;

@Service
public class AreasServiceImpl implements AreasService{

	@Autowired
	private AreasRepository areasRepository;

	@Override
	public List<Areas> getAllAreas() {
		return this.areasRepository.findAll();
	}

	@Override
	public void saveArea(Areas area) {
		this.areasRepository.save(area);
		
	}

	@Override
	public Areas getArea(int id) {
		Optional<Areas> optional = areasRepository.findById(id);
		Areas area = null;
		if(optional.isPresent()) {
			area = optional.get();
		}
		else {
			throw new RuntimeException("Location not found for id : "+id);
		}
		return area;
	}


	@Override
	public void deleteArea(int id) {
		this.areasRepository.deleteById(id);
		
	}

	@Override
	public Page<Areas> getAreasForDatatable(String queryString, Pageable pageable) {
		AreasDataFilter areasDataFilter = new AreasDataFilter(queryString);
		return areasRepository.findAll(areasDataFilter, pageable);
	}
	
	

}
