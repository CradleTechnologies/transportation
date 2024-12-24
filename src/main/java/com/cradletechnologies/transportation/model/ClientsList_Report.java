package com.cradletechnologies.transportation.model;

public class ClientsList_Report {
	
	private int id;
	private String firstName;
	private String lastName;
	private String clientName;
	private String status;
	private Double balance;

	public ClientsList_Report() {

	}

	public ClientsList_Report(int id, String firstName, String lastName, String clientName, String status,
			Double balance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clientName = clientName;
		this.status = status;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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
