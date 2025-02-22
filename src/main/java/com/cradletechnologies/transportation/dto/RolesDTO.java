package com.cradletechnologies.transportation.dto;

public class RolesDTO {

	private int id;
	private String name;
	private String description;
	
	
	//constructors
	public RolesDTO() {
		
	}


	public RolesDTO(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public RolesDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}


	//getters and setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
