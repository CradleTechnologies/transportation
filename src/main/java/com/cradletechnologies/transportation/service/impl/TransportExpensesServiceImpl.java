package com.cradletechnologies.transportation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cradletechnologies.transportation.filter.TransportExpensesDataFilter;
import com.cradletechnologies.transportation.filter.TrucksReportDataFilter;
//import com.cradletechnologies.transportation.model.TrucksList_Report;
import com.cradletechnologies.transportation.model.TransportExpenses;
import com.cradletechnologies.transportation.model.TrucksList_Report;
import com.cradletechnologies.transportation.repository.TransportExpensesRepository;
import com.cradletechnologies.transportation.service.TransportExpensesService;

@Service
public class TransportExpensesServiceImpl implements TransportExpensesService{

	@Autowired
	private TransportExpensesRepository transportExpensesRepository;

	@Transactional
	@Override
	public void truncateTransportExpenses() {
		transportExpensesRepository.truncateTransportExpenses();		
	}

	@Override
	public List<TransportExpenses> listTransportExpenses() {
		return transportExpensesRepository.findAll();
	}

	@Transactional
	@Override
	public void fillTransportationsToTransportExpenses() {
		transportExpensesRepository.fillTransportExpenses_Transportations();
		
	}

	@Transactional
	@Override
	public void fillExpensesToTransportExpenses() {
		transportExpensesRepository.fillTransportExpenses_Expenses();
		
	}
	
	
//	@Override
//	public List<TrucksList_Report> getTrucksListReport() {
//		return transportExpensesRepository.getTrucksListReport();
//	}


	@Override
	public int countTrucks() {		
		return transportExpensesRepository.getAvailableTrucksCount();
	}
//
//
//	@Override
//	public TrucksList_Report getTruckReport(int truckId) {
//		return transportExpensesRepository.getTruckReport(truckId);
//	}

//
//	@Override
//	public Transportation findTransportExpenses(String id) {
//		return transportExpensesRepository.findTransportExpense(id);
//	}

	
	@Override
	public Page<TransportExpenses> getTransportExpensesForDatatable(String queryString, Pageable pageable) {
		TransportExpensesDataFilter transportExpensesDataFilter = new TransportExpensesDataFilter(queryString);
		return transportExpensesRepository.findAll(transportExpensesDataFilter, pageable);
	}

	@Override
	public Page<TrucksList_Report> getTrucksListForDatatable(String queryString, Pageable pageable) {
		TrucksReportDataFilter trucksReportDataFilter = new TrucksReportDataFilter(queryString);
		return transportExpensesRepository.getTrucksReportForDatatable(trucksReportDataFilter, pageable);
	}



}


