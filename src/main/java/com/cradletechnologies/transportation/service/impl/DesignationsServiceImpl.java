package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.exception.ResourceNotFoundException;
import com.cradletechnologies.transportation.filter.DesignationsDataFilter;
import com.cradletechnologies.transportation.model.Designations;
import com.cradletechnologies.transportation.repository.DesignationsRepository;
import com.cradletechnologies.transportation.service.DesignationsService;

@Service
public class DesignationsServiceImpl implements DesignationsService{

	private DesignationsRepository designationsRepository;
	public DesignationsServiceImpl(DesignationsRepository designationsRepository) {
		super();
		this.designationsRepository = designationsRepository;
	}
	
	
	@Override
	public List<Designations> getAllDesignations() {
		return this.designationsRepository.findAll();
	}
	
	
	@Override
	public void saveDesignation(Designations designation) {
		this.designationsRepository.save(designation);
	}
	
	
	@Override
	public Designations getDesignation(int id) {
		Optional<Designations> optional = designationsRepository.findById(id);
        Designations designation = null;
        if (optional.isPresent()) {
            designation = optional.get();
        } else {
            throw new RuntimeException("Designation not found for id : " + id);
        }
        return designation;
    }
	
	
	@Override
	public void deleteDesignation(int id) {
		designationsRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Designation does not exist in the db with the id : ", "Id", id));
		designationsRepository.deleteById(id);
		
	}
	
	
	@Override
	public Page<Designations> getDesignationsForDatatable(String queryString, Pageable pageable) {
		DesignationsDataFilter designationsDataFilter = new DesignationsDataFilter(queryString);
		return designationsRepository.findAll(designationsDataFilter, pageable);
	}

}
