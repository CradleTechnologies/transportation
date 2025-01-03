package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.exception.ResourceNotFoundException;
import com.cradletechnologies.transportation.filter.CashInDataFilter;
import com.cradletechnologies.transportation.model.CashIn;
import com.cradletechnologies.transportation.repository.CashInRepository;
import com.cradletechnologies.transportation.service.CashInService;

@Service
public class CashInServiceImpl implements CashInService{

	private CashInRepository cashInRepository;
	public CashInServiceImpl(CashInRepository cashInRepository) {
		super();
		this.cashInRepository = cashInRepository;
	}
	
	
	@Override
	public List<CashIn> getAllCashIn() {
		return this.cashInRepository.findAll();
	}
	
	
	@Override
	public void saveCashIn(CashIn cashIn) {
		this.cashInRepository.save(cashIn);
	}
	
	
	@Override
	public CashIn getCashIn(int id) {
		Optional<CashIn> optional = cashInRepository.findById(id);
        CashIn cashIn = null;
        if (optional.isPresent()) {
            cashIn = optional.get();
        } else {
            throw new RuntimeException("CashIn not found for id : " + id);
        }
        return cashIn;
    }
	
	
	@Override
	public void deleteCashIn(int id) {
		cashInRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("CashIn does not exist in the db with the id : ", "Id", id));
		cashInRepository.deleteById(id);
		
	}
	
	
	@Override
	public Page<CashIn> getCashInForDatatable(String queryString, Pageable pageable) {
		CashInDataFilter cashInDataFilter = new CashInDataFilter(queryString);
		return cashInRepository.findAll(cashInDataFilter, pageable);
	}

}
