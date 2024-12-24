package com.cradletechnologies.transportation.dto;

public class AreasDTO {

	private int id;
	
	private String areaCode;
	
	private String areaName;
		
	private Double transportCharges;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Double getTransportCharges() {
		return transportCharges;
	}
	public void setTransportCharges(Double transportCharges) {
		this.transportCharges = transportCharges;
	}

	public AreasDTO() {
		
	}
	public AreasDTO(int id, String areaCode, String areaName, Double transportCharges) {
		super();
		this.id = id;
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.transportCharges = transportCharges;
	}
	public AreasDTO( String areaCode, String areaName, Double transportCharges) {
		super();
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.transportCharges = transportCharges;
	}
	
	@Override
	public String toString() {
		return "AreasDTO [areaCode=" + areaCode + "]";
	}
	
	
	
}
