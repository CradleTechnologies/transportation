package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.exception.ResourceNotFoundException;
import com.cradletechnologies.transportation.filter.ComplainsDataFilter;
import com.cradletechnologies.transportation.model.Complains;
import com.cradletechnologies.transportation.repository.ComplainsRepository;
import com.cradletechnologies.transportation.service.ComplainsService;

@Service
public class ComplainsServiceImpl implements ComplainsService{

	private ComplainsRepository complainsRepository;
	public ComplainsServiceImpl(ComplainsRepository complainsRepository) {
		super();
		this.complainsRepository = complainsRepository;
	}
	
	
	@Override
	public List<Complains> getAllComplains() {
		return this.complainsRepository.findAll();
	}
	
	
	@Override
	public void saveComplain(Complains complain) {
		this.complainsRepository.save(complain);
	}
	
	
	@Override
	public Complains getComplain(int id) {
		Optional<Complains> optional = complainsRepository.findById(id);
        Complains complain = null;
        if (optional.isPresent()) {
            complain = optional.get();
        } else {
            throw new RuntimeException("Complain not found for id : " + id);
        }
        return complain;
    }
	
	
	@Override
	public void deleteComplain(int id) {
		complainsRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Complain does not exist in the db with the id : ", "Id", id));
		complainsRepository.deleteById(id);
		
	}
	
	
	@Override
	public Page<Complains> getComplainsForDatatable(String queryString, Pageable pageable) {
		ComplainsDataFilter complainsDataFilter = new ComplainsDataFilter(queryString);
		return complainsRepository.findAll(complainsDataFilter, pageable);
	}

}
