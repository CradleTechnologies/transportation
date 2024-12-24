package com.cradletechnologies.transportation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cradletechnologies.transportation.filter.ClientsReportDataFilter;
import com.cradletechnologies.transportation.filter.PaymentBillingDataFilter;
import com.cradletechnologies.transportation.model.ClientsList_Report;
import com.cradletechnologies.transportation.model.PaymentBilling;
import com.cradletechnologies.transportation.repository.PaymentBillingRepository;
import com.cradletechnologies.transportation.service.PaymentBillingService;

@Service
public class PaymentBillingServiceImpl implements PaymentBillingService{

	@Autowired
	private PaymentBillingRepository paymentBillingRepository;

	@Transactional
	@Override
	public void truncatePaymentBilling() {
		paymentBillingRepository.truncatePaymentBilling();		
	}

	@Override
	public List<PaymentBilling> listPaymentBilling() {
		return paymentBillingRepository.findAll();
	}

	@Transactional
	@Override
	public void fillPaymentsToPaymentBilling() {
		paymentBillingRepository.fillPaymentBilling_Payments();
		
	}

	@Transactional
	@Override
	public void fillBillingToPaymentBilling() {
		paymentBillingRepository.fillPaymentBilling_Billing();
		
	}
	
	@Transactional
	@Override
	public void fillSaleToPaymentBilling() {
		paymentBillingRepository.fillPaymentBilling_Sale();
		
	}


	@Override
	public List<ClientsList_Report> getClientsListReport() {
		return paymentBillingRepository.getClientsListReport();
	}

	
//	@Override
//	public ProductSales findClient(int id) {
//		return paymentBillingRepository.getClientBillingInfo(id);
//	}



	@Override
	public int countClients() {		
		return paymentBillingRepository.getClientsCount();
	}

	@Override
	public Double totalRevenue() {
		return paymentBillingRepository.getTotalRevenue();
	}
	
	@Override
	public Double totalInvoices() {
		return paymentBillingRepository.getTotalInvoices();
	}
	
	@Override
	public Double bookBalance() {
		Double receipts = paymentBillingRepository.getTotalRevenue();
		Double invoices = paymentBillingRepository.getTotalInvoices();
		Double balance = receipts - invoices; 
		return balance;
	}

	@Override
	public ClientsList_Report getClientReport(int clientId) {
		return paymentBillingRepository.getClientReport(clientId);
	}

	@Override
	public Page<PaymentBilling> getPaymentBillingForDatatable(String queryString, Pageable pageable) {
		PaymentBillingDataFilter paymentBillingDataFilter = new PaymentBillingDataFilter(queryString);
		return paymentBillingRepository.findAll(paymentBillingDataFilter, pageable);
	}

	@Override
	public Page<ClientsList_Report> getClientsListForDatatable(String queryString, Pageable pageable) {
		ClientsReportDataFilter clientsReportDataFilter = new ClientsReportDataFilter(queryString);
		return paymentBillingRepository.getClientsReportForDatatable(clientsReportDataFilter, pageable);
	}


}


