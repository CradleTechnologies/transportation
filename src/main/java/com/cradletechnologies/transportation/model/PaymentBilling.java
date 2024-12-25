package com.cradletechnologies.transportation.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "payment_transportation", catalog = "cradle_transport", schema = "")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name ="PaymentBilling.findAll", query = "SELECT pb FROM PaymentBilling pb"),
	@NamedQuery(name = "PaymentBilling.findByClientId", query = "SELECT pb FROM PaymentBilling pb WHERE pb.clientId = :clientId"),
	@NamedQuery(name = "PaymentBilling.findByPaymentId", query = "SELECT pb FROM PaymentBilling pb WHERE pb.paymentId = :paymentId"),
	@NamedQuery(name = "PaymentBilling.findByTransportationId", query = "SELECT pb FROM PaymentBilling pb WHERE pb.transportationId = :transportationId")})

public class PaymentBilling implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "record_date", nullable = false, length = 200)
	private Date recordDate;
	
	@Column(name = "client_id", nullable = false, length = 200)
	private int clientId;
	
	@Column(name = "payment_id", nullable = false, length = 200)
	private int paymentId;
	
	@Column(name = "transportation_id", nullable = false, length = 200)
	private int transportationId;
	
	@Column(name = "amount", nullable = false, length = 200)
	private double amount;

	
	//Constructors
	public PaymentBilling() {
		
	}


	public PaymentBilling(int id, Date recordDate, int clientId, int paymentId, int transportationId, double amount) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.clientId = clientId;
		this.paymentId = paymentId;
		this.transportationId = transportationId;
		this.amount = amount;
	}


	public PaymentBilling(Date recordDate, int clientId, int paymentId, int transportationId, double amount) {
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


	
	//To String
	@Override
	public String toString() {
		return "PaymentBilling [id=" + id + "]";
	}

	
	
	
	

}
