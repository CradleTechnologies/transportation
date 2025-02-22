package com.cradletechnologies.transportation.model;

import java.util.Date;

public class ClientsList_Report {

	private int id;
	private Date recordDate;
	private String firstName;
	private String lastName;
	private String clientName;
	private String telNo;
	private String areaName;
	private Double transport;
	private Double payment;
	private Double cashIn;
	private Double cashOut;
	private String status;
	private Double balance;

	public ClientsList_Report() {

	}

	
	public ClientsList_Report(int id, Date recordDate, String firstName, String lastName, String clientName,
			String telNo, String areaName, Double transport, Double payment, Double cashIn, Double cashOut,
			String status, Double balance) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clientName = clientName;
		this.telNo = telNo;
		this.areaName = areaName;
		this.transport = transport;
		this.payment = payment;
		this.cashIn = cashIn;
		this.cashOut = cashOut;
		this.status = status;
		this.balance = balance;
	}


	public ClientsList_Report(int id, Date recordDate, String firstName, String lastName, String clientName,
			Double transport, Double payment, Double cashIn, Double cashOut, String status, Double balance) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clientName = clientName;
		this.transport = transport;
		this.payment = payment;
		this.cashIn = cashIn;
		this.cashOut = cashOut;
		this.status = status;
		this.balance = balance;
	}


	public ClientsList_Report(int id, String firstName, String lastName, String clientName, Double transport,
			Double payment, Double cashIn, Double cashOut, String status, Double balance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clientName = clientName;
		this.transport = transport;
		this.payment = payment;
		this.cashIn = cashIn;
		this.cashOut = cashOut;
		this.status = status;
		this.balance = balance;
	}

	public ClientsList_Report(String firstName, String lastName, String clientName, Double transport, Double payment,
			Double cashIn, Double cashOut, String status, Double balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.clientName = clientName;
		this.transport = transport;
		this.payment = payment;
		this.cashIn = cashIn;
		this.cashOut = cashOut;
		this.status = status;
		this.balance = balance;
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

	public ClientsList_Report(int id, String clientName, String status, Double balance) {
		super();
		this.id = id;
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

	public Date getRecordDate() {
		return recordDate;
	}


	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
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

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Double getTransport() {
		return transport;
	}

	public void setTransport(Double transport) {
		this.transport = transport;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Double getCashIn() {
		return cashIn;
	}

	public void setCashIn(Double cashIn) {
		this.cashIn = cashIn;
	}

	public Double getCashOut() {
		return cashOut;
	}

	public void setCashOut(Double cashOut) {
		this.cashOut = cashOut;
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

	@Override
	public String toString() {
		return "ClientsList_Report [id=" + id + ", clientName=" + clientName + ", balance=" + balance + "]";
	}

}
