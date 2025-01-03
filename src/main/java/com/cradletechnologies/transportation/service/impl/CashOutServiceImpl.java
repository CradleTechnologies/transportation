package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.exception.ResourceNotFoundException;
import com.cradletechnologies.transportation.filter.CashOutDataFilter;
import com.cradletechnologies.transportation.model.CashOut;
import com.cradletechnologies.transportation.repository.CashOutRepository;
import com.cradletechnologies.transportation.service.CashOutService;

@Service
public class CashOutServiceImpl implements CashOutService{

	private CashOutRepository cashOutRepository;
	public CashOutServiceImpl(CashOutRepository cashOutRepository) {
		super();
		this.cashOutRepository = cashOutRepository;
	}
	
	
	@Override
	public List<CashOut> getAllCashOut() {
		return this.cashOutRepository.findAll();
	}
	
	
	@Override
	public void saveCashOut(CashOut cashOut) {
		this.cashOutRepository.save(cashOut);
	}
	
	
	@Override
	public CashOut getCashOut(int id) {
		Optional<CashOut> optional = cashOutRepository.findById(id);
        CashOut cashOut = null;
        if (optional.isPresent()) {
            cashOut = optional.get();
        } else {
            throw new RuntimeException("CashOut not found for id : " + id);
        }
        return cashOut;
    }
	
	
	@Override
	public void deleteCashOut(int id) {
		cashOutRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("CashOut does not exist in the db with the id : ", "Id", id));
		cashOutRepository.deleteById(id);
		
	}
	
	
	@Override
	public Page<CashOut> getCashOutForDatatable(String queryString, Pageable pageable) {
		CashOutDataFilter cashOutDataFilter = new CashOutDataFilter(queryString);
		return cashOutRepository.findAll(cashOutDataFilter, pageable);
	}

}
