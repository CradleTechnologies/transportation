package com.cradletechnologies.transportation.model;

public class TrucksList_Report {
	
	private int id;
	private String registrationNo;
	private String driverName;
	private Double capacity;
	private String status;
	private Double balance;

	public TrucksList_Report() {

	}

	public TrucksList_Report(int id, String registrationNo, String driverName, Double capacity, String status,
			Double balance) {
		super();
		this.id = id;
		this.registrationNo = registrationNo;
		this.driverName = driverName;
		this.capacity = capacity;
		this.status = status;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
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
