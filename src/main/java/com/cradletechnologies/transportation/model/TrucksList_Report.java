package com.cradletechnologies.transportation.model;

import java.util.Date;

public class TrucksList_Report {
	
	private int id;
	private Date recordDate;
	private String registrationNo;
	private String driverName;
	private String telNo;
	private Double capacity;
	private Double transportCharges;
	private Double amountPaid;
	private String status;
	private Double balance;

	public TrucksList_Report() {

	}

	
	public TrucksList_Report(int id, Date recordDate, String registrationNo, String driverName, String telNo,
			Double capacity, Double transportCharges, Double amountPaid, String status, Double balance) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.registrationNo = registrationNo;
		this.driverName = driverName;
		this.telNo = telNo;
		this.capacity = capacity;
		this.transportCharges = transportCharges;
		this.amountPaid = amountPaid;
		this.status = status;
		this.balance = balance;
	}


	public TrucksList_Report(int id, Date recordDate, String registrationNo, String driverName, Double capacity,
			Double transportCharges, Double amountPaid, String status, Double balance) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.registrationNo = registrationNo;
		this.driverName = driverName;
		this.capacity = capacity;
		this.transportCharges = transportCharges;
		this.amountPaid = amountPaid;
		this.status = status;
		this.balance = balance;
	}


	public TrucksList_Report(int id, String registrationNo, String driverName, Double capacity, Double transportCharges,
			Double amountPaid, String status, Double balance) {
		super();
		this.id = id;
		this.registrationNo = registrationNo;
		this.driverName = driverName;
		this.capacity = capacity;
		this.transportCharges = transportCharges;
		this.amountPaid = amountPaid;
		this.status = status;
		this.balance = balance;
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


	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public Double getTransportCharges() {
		return transportCharges;
	}

	public void setTransportCharges(Double transportCharges) {
		this.transportCharges = transportCharges;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
