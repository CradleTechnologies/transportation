package com.cradletechnologies.transportation.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "transport_expenses", catalog = "cradle_transport", schema = "")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name ="TransportExpenses.findAll", query = "SELECT te FROM TransportExpenses te"),
	@NamedQuery(name = "TransportExpenses.findByTruckId", query = "SELECT te FROM TransportExpenses te WHERE te.truckId = :truckId"),
	@NamedQuery(name = "TransportExpenses.findByTransportId", query = "SELECT te FROM TransportExpenses te WHERE te.transportId = :transportId"),
	@NamedQuery(name = "TransportExpenses.findByExpenseId", query = "SELECT te FROM TransportExpenses te WHERE te.expenseId = :expenseId")})

public class TransportExpenses implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "record_date", nullable = false, length = 200)
	private Date recordDate;
	
	@Column(name = "truck_id", nullable = false, length = 200)
	private int truckId;
	
	@Column(name = "transport_id", nullable = false, length = 200)
	private int transportId;
	
	@Column(name = "expense_id", nullable = false, length = 200)
	private int expenseId;
			
	@Column(name = "amount", nullable = false, length = 200)
	private double amount;

	
	public TransportExpenses() {
		
	}
		
	public TransportExpenses(int id, Date recordDate, int truckId, int transportId, int expenseId, double amount) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.truckId = truckId;
		this.transportId = transportId;
		this.expenseId = expenseId;
		this.amount = amount;
	}

	public TransportExpenses(Date recordDate, int truckId, int transportId, int expenseId, double amount) {
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
		return "TransportExpense [id=" + id + ", amount=" + amount + "]";
	}

}
