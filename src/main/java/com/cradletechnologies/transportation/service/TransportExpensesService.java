package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.TransportExpenses;
import com.cradletechnologies.transportation.model.TrucksList_Report;

public interface TransportExpensesService {

	void truncateTransportExpenses();
	
	void fillTransportationsToTransportExpenses();
	
	void fillExpensesToTransportExpenses();
	
	List<TransportExpenses> listTransportExpenses();
	
//	List<ClientsList_Report> getClientsListReport();
		
	int countTrucks();

	
//	TrucksList_Report getTruckReport(int truckId);
	
	Page<TransportExpenses> getTransportExpensesForDatatable(String queryString, Pageable pageable);
	
	Page<TrucksList_Report> getTrucksListForDatatable(String queryString, Pageable pageable);

//	Transportation findTransportExpenses(String id);
	
}
