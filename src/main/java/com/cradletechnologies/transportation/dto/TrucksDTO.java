package com.cradletechnologies.transportation.dto;

import com.cradletechnologies.transportation.model.Areas;
import com.cradletechnologies.transportation.model.AuditIdentifier;
import com.cradletechnologies.transportation.model.Staffs;

public class TrucksDTO {

	    private int id;

	    private String registrationNo;
	   
	    private Double capacity;
	    
	    private String description;
	    
	    private Staffs staff;
 
	    private Areas area;
	    
		public TrucksDTO() {

		}

		public TrucksDTO(int id, String registrationNo, Double capacity, String description, Staffs staff, Areas area) {
			super();
			this.id = id;
			this.registrationNo = registrationNo;
			this.capacity = capacity;
			this.description = description;
			this.staff = staff;
			this.area = area;
		}

		public TrucksDTO(String registrationNo, Double capacity, String description, Staffs staff, Areas area) {
			super();
			this.registrationNo = registrationNo;
			this.capacity = capacity;
			this.description = description;
			this.staff = staff;
			this.area = area;
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


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public Staffs getStaff() {
			return staff;
		}


		public void setStaff(Staffs staff) {
			this.staff = staff;
		}


		public Areas getArea() {
			return area;
		}


		public void setArea(Areas area) {
			this.area = area;
		}


		@Override
		public String toString() {
			return "TrucksDTO [registrationNo=" + registrationNo + ", description=" + description + "]";
		}
}
	    
	    
	    