package com.cradletechnologies.transportation.dto;

import java.sql.Date;

import com.cradletechnologies.transportation.model.Areas;
import com.cradletechnologies.transportation.model.Designations;

import jakarta.persistence.Transient;

public class StaffsDTO {

	private int id;
	private Date recordDate;
	private String firstName;
	private String lastName;
	private String staffName;
	private String idNo;
	private String telNo;
	private String email;
	private String gender;
	private String status;
	private String detailedResidence;
	private String achievements;
	private Double salaryAmount;
	private String scannedDocument;
	private String staffPicture;
	private Designations designation;
	private Areas areas;
	
	
	public StaffsDTO() {
		
	}


	public StaffsDTO(int id, Date recordDate, String firstName, String lastName, String staffName, String idNo,
			String telNo, String email, String gender, String status, String detailedResidence, String achievements,
			Double salaryAmount, String scannedDocument, String staffPicture, Designations designation, Areas areas) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.staffName = staffName;
		this.idNo = idNo;
		this.telNo = telNo;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.detailedResidence = detailedResidence;
		this.achievements = achievements;
		this.salaryAmount = salaryAmount;
		this.scannedDocument = scannedDocument;
		this.staffPicture = staffPicture;
		this.designation = designation;
		this.areas = areas;
	}


	public StaffsDTO(Date recordDate, String firstName, String lastName, String staffName, String idNo, String telNo,
			String email, String gender, String status, String detailedResidence, String achievements,
			Double salaryAmount, String scannedDocument, String staffPicture, Designations designation, Areas areas) {
		super();
		this.recordDate = recordDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.staffName = staffName;
		this.idNo = idNo;
		this.telNo = telNo;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.detailedResidence = detailedResidence;
		this.achievements = achievements;
		this.salaryAmount = salaryAmount;
		this.scannedDocument = scannedDocument;
		this.staffPicture = staffPicture;
		this.designation = designation;
		this.areas = areas;
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


	public String getStaffName() {
		return staffName;
	}


	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}


	public String getIdNo() {
		return idNo;
	}


	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}


	public String getTelNo() {
		return telNo;
	}


	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDetailedResidence() {
		return detailedResidence;
	}


	public void setDetailedResidence(String detailedResidence) {
		this.detailedResidence = detailedResidence;
	}


	public String getAchievements() {
		return achievements;
	}


	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}


	public Double getSalaryAmount() {
		return salaryAmount;
	}


	public void setSalaryAmount(Double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}


	public String getScannedDocument() {
		return scannedDocument;
	}


	public void setScannedDocument(String scannedDocument) {
		this.scannedDocument = scannedDocument;
	}


	public String getStaffPicture() {
		return staffPicture;
	}


	public void setStaffPicture(String staffPicture) {
		this.staffPicture = staffPicture;
	}


	public Designations getDesignation() {
		return designation;
	}


	public void setDesignation(Designations designation) {
		this.designation = designation;
	}


	public Areas getAreas() {
		return areas;
	}


	public void setAreas(Areas areas) {
		this.areas = areas;
	}
	
	@Transient
	public String getStaffPicturePath() {
		if(staffPicture == null || id == 0) return null;
		return "/staff-pictures/"+id+"/"+staffPicture;
	}

	@Transient
	public String getScannedDocumentPath() {
		if(scannedDocument == null || id == 0) return null;
		return "/staff-scanned-documents/"+id+"/"+scannedDocument;
	}
	

	@Override
	public String toString() {
		return "StaffsDTO [id=" + id + ", staffName=" + staffName + "]";
	}
	
}
