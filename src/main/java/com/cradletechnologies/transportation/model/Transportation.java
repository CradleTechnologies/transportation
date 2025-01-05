package com.cradletechnologies.transportation.model;

import java.util.Date;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class Transportation {

	private int id;
	private Date recordDate;
	private String clientName;
	private Double totalAmountPaid;
	private Double totalInvoices;
	private Double newTransportCharges;
	private Double balanceBf;
	private Double totalAmount;
	private String truckId;
	private String areaId;

	public Transportation() {
		
	}

	public Transportation(int id, Date recordDate, String clientName, Double totalAmountPaid, Double totalInvoices,
			Double newTransportCharges, Double balanceBf, Double totalAmount, String truckId, String areaId) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.clientName = clientName;
		this.totalAmountPaid = totalAmountPaid;
		this.totalInvoices = totalInvoices;
		this.newTransportCharges = newTransportCharges;
		this.balanceBf = balanceBf;
		this.totalAmount = totalAmount;
		this.truckId = truckId;
		this.areaId = areaId;
	}

	public Transportation(Date recordDate, String clientName, Double totalAmountPaid, Double totalInvoices,
			Double newTransportCharges, Double balanceBf, Double totalAmount, String truckId, String areaId) {
		super();
		this.recordDate = recordDate;
		this.clientName = clientName;
		this.totalAmountPaid = totalAmountPaid;
		this.totalInvoices = totalInvoices;
		this.newTransportCharges = newTransportCharges;
		this.balanceBf = balanceBf;
		this.totalAmount = totalAmount;
		this.truckId = truckId;
		this.areaId = areaId;
	}
		
	public Transportation(Date recordDate, String clientName, Double totalAmountPaid, Double totalInvoices,
			Double balanceBf) {
		super();
		this.recordDate = recordDate;
		this.clientName = clientName;
		this.totalAmountPaid = totalAmountPaid;
		this.totalInvoices = totalInvoices;
		this.balanceBf = balanceBf;
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

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Double getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(Double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}

	public Double getTotalInvoices() {
		return totalInvoices;
	}

	public void setTotalInvoices(Double totalInvoices) {
		this.totalInvoices = totalInvoices;
	}

	public Double getNewTransportCharges() {
		return newTransportCharges;
	}

	public void setNewTransportCharges(Double newTransportCharges) {
		this.newTransportCharges = newTransportCharges;
	}

	public Double getBalanceBf() {
		return balanceBf;
	}

	public void setBalanceBf(Double balanceBf) {
		this.balanceBf = balanceBf;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTruckId() {
		return truckId;
	}

	public void setTruckId(String truckId) {
		this.truckId = truckId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	
}
	
