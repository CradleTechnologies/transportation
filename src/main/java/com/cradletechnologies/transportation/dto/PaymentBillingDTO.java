package com.cradletechnologies.transportation.dto;

import java.util.Date;

import com.cradletechnologies.transportation.model.Clients;
import com.cradletechnologies.transportation.model.Payments;
import com.cradletechnologies.transportation.model.Transportations;

public class PaymentBillingDTO {

	private int id;
	
	private Date recordDate;
	
	private Clients clientId;
	
	private Payments paymentId;
	
	private Transportations transportationId;
	
	private double amount;


	public PaymentBillingDTO() {
		
	}


	public PaymentBillingDTO(int id, Date recordDate, Clients clientId, Payments paymentId,
			Transportations transportationId, double amount) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.clientId = clientId;
		this.paymentId = paymentId;
		this.transportationId = transportationId;
		this.amount = amount;
	}


	public PaymentBillingDTO(Date recordDate, Clients clientId, Payments paymentId, Transportations transportationId,
			double amount) {
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


	public Clients getClientId() {
		return clientId;
	}


	public void setClientId(Clients clientId) {
		this.clientId = clientId;
	}


	public Payments getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Payments paymentId) {
		this.paymentId = paymentId;
	}


	public Transportations getTransportationId() {
		return transportationId;
	}


	public void setTransportationId(Transportations transportationId) {
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
		return "PaymentBillingDTO [id=" + id + ", amount=" + amount + "]";
	}

}
