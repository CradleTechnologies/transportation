package com.cradletechnologies.transportation.dto;

import java.util.Date;

public class PaymentBillingDTO {

	private int id;
	
	private Date recordDate;
	
	private int clientId;
	
	private int paymentId;
	
	private int transportationId;
	
	private double amount;


	public PaymentBillingDTO() {
		
	}


	public PaymentBillingDTO(int id, Date recordDate, int clientId, int paymentId, int transportationId, double amount) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.clientId = clientId;
		this.paymentId = paymentId;
		this.transportationId = transportationId;
		this.amount = amount;
	}


	public PaymentBillingDTO(Date recordDate, int clientId, int paymentId, int transportationId, double amount) {
		super();
		this.recordDate = recordDate;
		this.clientId = clientId;
		this.paymentId = paymentId;
		this.transportationId = transportationId;
		this.amount = amount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getRecordDate() {
		return recordDate;
	}


	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}


	public int getClientId() {
		return clientId;
	}


	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public int getTransportationId() {
		return transportationId;
	}


	public void setTransportationId(int transportationId) {
		this.transportationId = transportationId;
	}



	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "PaymentBillingDTO [id=" + id + "]";
	}


}
