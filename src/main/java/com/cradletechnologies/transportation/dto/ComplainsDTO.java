package com.cradletechnologies.transportation.dto;

import java.sql.Date;

public class ComplainsDTO {

	private int id;
	private Date recordDate;
	private String complainant;
	private String telNo;
	private String addressee;
	private String details;
	private String status;
	
	public ComplainsDTO() {
		
	}

	public ComplainsDTO(int id, Date recordDate, String complainant, String telNo, String addressee, String details,
			String status) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.complainant = complainant;
		this.telNo = telNo;
		this.addressee = addressee;
		this.details = details;
		this.status = status;
	}

	public ComplainsDTO(Date recordDate, String complainant, String telNo, String addressee, String details,
			String status) {
		super();
		this.recordDate = recordDate;
		this.complainant = complainant;
		this.telNo = telNo;
		this.addressee = addressee;
		this.details = details;
		this.status = status;
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

	public String getComplainant() {
		return complainant;
	}

	public void setComplainant(String complainant) {
		this.complainant = complainant;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ComplainsDTO [id=" + id + "]";
	}
	
	

}
