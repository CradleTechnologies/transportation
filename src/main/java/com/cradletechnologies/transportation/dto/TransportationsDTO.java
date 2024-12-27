package com.cradletechnologies.transportation.dto;

import java.util.Date;

import com.cradletechnologies.transportation.model.Areas;
import com.cradletechnologies.transportation.model.Clients;
import com.cradletechnologies.transportation.model.Trucks;

public class TransportationsDTO {

	    private int id;

		private Date transportDate;
		
		private Date offLoadingDate;
		
		private String status;

	    private Double transportCharges;
	    
	    private String transportDetails;

	    private Trucks truck;
	    
	    private Areas area;
	    
	    private Clients client;
	    
		public TransportationsDTO() {
			
			}

		public TransportationsDTO(int id, Date transportDate, Date offLoadingDate, String status,
				Double transportCharges, String transportDetails, Trucks truck, Areas area, Clients client) {
			super();
			this.id = id;
			this.transportDate = transportDate;
			this.offLoadingDate = offLoadingDate;
			this.status = status;
			this.transportCharges = transportCharges;
			this.transportDetails = transportDetails;
			this.truck = truck;
			this.area = area;
			this.client = client;
		}

		public TransportationsDTO(Date transportDate, Date offLoadingDate, String status, Double transportCharges,
				 String transportDetails, Trucks truck, Areas area, Clients client) {
			super();
			this.transportDate = transportDate;
			this.offLoadingDate = offLoadingDate;
			this.status = status;
			this.transportCharges = transportCharges;
			this.transportDetails = transportDetails;
			this.truck = truck;
			this.area = area;
			this.client = client;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getTransportDate() {
			return transportDate;
		}

		public void setTransportDate(Date transportDate) {
			this.transportDate = transportDate;
		}

		public Date getOffLoadingDate() {
			return offLoadingDate;
		}

		public void setOffLoadingDate(Date offLoadingDate) {
			this.offLoadingDate = offLoadingDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Double getTransportCharges() {
			return transportCharges;
		}

		public void setTransportCharges(Double transportCharges) {
			this.transportCharges = transportCharges;
		}

		public String getTransportDetails() {
			return transportDetails;
		}

		public void setTransportDetails(String transportDetails) {
			this.transportDetails = transportDetails;
		}

		public Trucks getTruck() {
			return truck;
		}

		public void setTruck(Trucks truck) {
			this.truck = truck;
		}

		public Areas getArea() {
			return area;
		}

		public void setArea(Areas area) {
			this.area = area;
		}

		public Clients getClient() {
			return client;
		}

		public void setClient(Clients client) {
			this.client = client;
		}

		@Override
		public String toString() {
			return "TransportationsDTO [id=" + id + ", transportDate=" + transportDate + ", transportDetails="
					+ transportDetails + ", truck=" + truck + "]";
		}

			 
}