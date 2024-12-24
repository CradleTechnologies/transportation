package com.cradletechnologies.transportation.dto;

import java.sql.Date;

import com.cradletechnologies.transportation.model.Clients;
import com.cradletechnologies.transportation.model.Designations;

public class CashOutDTO {

	private int id;
	private Date recordDate;
	private Double amount;
	private String remarks;
	private Clients client;
	private Designations designation;
	
	
	//Constructors
	public CashOutDTO() {
		
	}


	public CashOutDTO(int id, Date recordDate, Double amount, String remarks, Clients client, Designations designation) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.amount = amount;
		this.remarks = remarks;
		this.client = client;
		this.designation = designation;
	}


	public CashOutDTO(Date recordDate, Double amount, String remarks, Clients client, Designations designation) {
		super();
		this.recordDate = recordDate;
		this.amount = amount;
		this.remarks = remarks;
		this.client = client;
		this.designation = designation;
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


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Clients getClients() {
		return client;
	}


	public void setClients(Clients client) {
		this.client = client;
	}


	public Designations getDesignation() {
		return designation;
	}


	public void setDesignation(Designations designation) {
		this.designation = designation;
	}


	@Override
	public String toString() {
		return "CashOutDTO [id=" + id + "]";
	}
	
	

}
