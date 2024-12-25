package com.cradletechnologies.transportation.dto;

import java.io.Serializable;

import com.cradletechnologies.transportation.model.Areas;

public class ClientsDTO implements Serializable {

	    private int id;

	    private String firstName;

	    private String lastName;
	    
	    private String clientName;
	    
	    private String emailAddress;

	    private String telNo;
	    
	    private String status;

	    private Areas areas;

		public ClientsDTO() {
			
		}
			
		public ClientsDTO(int id) {
			super();
			this.id = id;
		}
    	
	    public ClientsDTO(int id, String firstName, String lastName, String clientName, String emailAddress, String telNo, String status, Areas areas) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.clientName = clientName;
			this.emailAddress = emailAddress;
			this.telNo = telNo;
			this.status= status;
			this.areas = areas;
		}

		public ClientsDTO(String firstName, String lastName, String clientName, String emailAddress, String telNo, String status, Areas areas) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.clientName = clientName;
			this.emailAddress = emailAddress;
			this.telNo = telNo;
			this.status= status;
			this.areas = areas;
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

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getTelNo() {
			return telNo;
		}

		public void setTelNo(String telNo) {
			this.telNo = telNo;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Areas getAreas() {
			return areas;
		}

		public void setAreas(Areas areas) {
			this.areas = areas;
		}

		//check out
	    @Override
	    public String toString() {
	        return "ClientsDTO[ id=" + id + " ]";
	    }

}
