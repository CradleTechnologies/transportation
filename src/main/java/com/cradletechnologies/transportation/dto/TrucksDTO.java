package com.cradletechnologies.transportation.dto;

import com.cradletechnologies.transportation.model.Companies;
import com.cradletechnologies.transportation.model.AuditIdentifier;
import com.cradletechnologies.transportation.model.Staffs;

import jakarta.persistence.Transient;

public class TrucksDTO {

	    private int id;

	    private String registrationNo;
	   
	    private Double capacity;
	    
	    private String status;
	    
	    private String description;   	
	    
	    private String truckPicture;	    
	    
	    private Staffs staff;
 
	    private Companies company;
	    
		public TrucksDTO() {

		}
				
		public TrucksDTO(int id, String registrationNo, Double capacity, String status, String description, String truckPicture,
				Staffs staff, Companies company) {
			super();
			this.id = id;
			this.registrationNo = registrationNo;
			this.capacity = capacity;
			this.status = status;
			this.description = description;
			this.truckPicture = truckPicture;
			this.staff = staff;
			this.company = company;
		}

		public TrucksDTO(String registrationNo, Double capacity, String status, String description, String truckPicture, Staffs staff,
				Companies company) {
			super();
			this.registrationNo = registrationNo;
			this.capacity = capacity;
			this.status = status;
			this.description = description;
			this.truckPicture = truckPicture;
			this.staff = staff;
			this.company = company;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTruckPicture() {
			return truckPicture;
		}

		public void setTruckPicture(String truckPicture) {
			this.truckPicture = truckPicture;
		}

		public Staffs getStaff() {
			return staff;
		}

		public void setStaff(Staffs staff) {
			this.staff = staff;
		}

		public Companies getCompany() {
			return company;
		}

		public void setCompany(Companies company) {
			this.company = company;
		}

		@Transient
		public String getTruckPicturePath() {
			if(truckPicture == null || id == 0) return null;
			return "/truck-pictures/"+id+"/"+truckPicture;
		}

		@Override
		public String toString() {
			return "TrucksDTO [registrationNo=" + registrationNo + ", description=" + description + "]";
		}
}
	    
	    
	    