package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.filter.PayBoxesDataFilter;
import com.cradletechnologies.transportation.model.PayBoxes;
import com.cradletechnologies.transportation.repository.PayBoxesRepository;
import com.cradletechnologies.transportation.service.PayBoxesService;

@Service
public class PayBoxesServiceImpl implements PayBoxesService{

	@Autowired
	private PayBoxesRepository payBoxesRepository;

	@Override
	public List<PayBoxes> getAllPayBoxes() {
		return this.payBoxesRepository.findAll();
	}

	@Override
	public PayBoxes savePayBox(PayBoxes payBox) {
		return this.payBoxesRepository.save(payBox);
		
	}

	@Override
	public PayBoxes getPayBox(int id) {
		Optional<PayBoxes> optional = payBoxesRepository.findById(id);
		PayBoxes payBox = null;
		if(optional.isPresent()) {
			payBox = optional.get();
		}
		else {
			throw new RuntimeException("Location not found for id : "+id);
		}
		return payBox;
	}


	@Override
	public void deletePayBox(int id) {
		this.payBoxesRepository.deleteById(id);
		
	}

	@Override
	public Page<PayBoxes> getPayBoxesForDatatable(String queryString, Pageable pageable) {
		PayBoxesDataFilter payBoxesDataFilter = new PayBoxesDataFilter(queryString);
		return payBoxesRepository.findAll(payBoxesDataFilter, pageable);
	}
	
	

}
