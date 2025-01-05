package com.cradletechnologies.transportation.dto;

import java.sql.Date;

public class TransportExpensesDTO {

	private int id;
	
	private Date recordDate;
	
	private int truckId;
	
	private int transportId;
	
	private int expenseId;
		
	private double amount;

	
	public TransportExpensesDTO() {
		
	}
		
	public TransportExpensesDTO(int id, Date recordDate, int truckId, int transportId, int expenseId, double amount) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.truckId = truckId;
		this.transportId = transportId;
		this.expenseId = expenseId;
		this.amount = amount;
	}

	public TransportExpensesDTO(Date recordDate, int truckId, int transportId, int expenseId, double amount) {
		super();
		this.recordDate = recordDate;
		this.truckId = truckId;
		this.transportId = transportId;
		this.expenseId = expenseId;
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

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public int getTransportId() {
		return transportId;
	}

	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransportExpensesDTO [id=" + id + ", amount=" + amount + "]";
	}

}
