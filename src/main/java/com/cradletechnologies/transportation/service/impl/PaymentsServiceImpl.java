package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.exception.ResourceNotFoundException;
import com.cradletechnologies.transportation.filter.PaymentsDataFilter;
import com.cradletechnologies.transportation.model.Payments;
import com.cradletechnologies.transportation.repository.PaymentsRepository;
import com.cradletechnologies.transportation.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService{

	private PaymentsRepository paymentsRepository;
	public PaymentsServiceImpl(PaymentsRepository paymentsRepository) {
		super();
		this.paymentsRepository = paymentsRepository;
	}
	
	
	@Override
	public List<Payments> getAllPayments() {
		return this.paymentsRepository.findAll();
	}
	
	
	@Override
	public Payments savePayment(Payments payment) {
		return this.paymentsRepository.save(payment);
	}
	
	
	@Override
	public Payments getPayment(int id) {
		Optional<Payments> optional = paymentsRepository.findById(id);
        Payments payment = null;
        if (optional.isPresent()) {
            payment = optional.get();
        } else {
            throw new RuntimeException("Payment not found for id : " + id);
        }
        return payment;
    }
	
	
	@Override
	public void deletePayment(int id) {
		paymentsRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Payment does not exist in the db with the id : ", "Id", id));
		paymentsRepository.deleteById(id);
		
	}
	
	
	@Override
	public Page<Payments> getPaymentsForDatatable(String queryString, Pageable pageable) {
		PaymentsDataFilter paymentsDataFilter = new PaymentsDataFilter(queryString);
		return paymentsRepository.findAll(paymentsDataFilter, pageable);
	}

}
