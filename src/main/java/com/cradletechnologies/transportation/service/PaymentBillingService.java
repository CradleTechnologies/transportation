package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.ClientsList_Report;
import com.cradletechnologies.transportation.model.PaymentBilling;

public interface PaymentBillingService {

	void truncatePaymentBilling();
	
	void fillPaymentsToPaymentBilling();
	
	void fillBillingToPaymentBilling();
	
	void fillSaleToPaymentBilling();
	
	List<PaymentBilling> listPaymentBilling();
	
	List<ClientsList_Report> getClientsListReport();
	
//	ProductSales findClient(int id);	
	
	int countClients();
	
	Double totalRevenue();
	
	Double totalInvoices();
	
	Double bookBalance();
	
	ClientsList_Report getClientReport(int clientId);
	
	Page<PaymentBilling> getPaymentBillingForDatatable(String queryString, Pageable pageable);
	
	Page<ClientsList_Report> getClientsListForDatatable(String queryString, Pageable pageable);
	
}
