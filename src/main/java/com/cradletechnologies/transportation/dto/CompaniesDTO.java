package com.cradletechnologies.transportation.dto;

import com.cradletechnologies.transportation.model.Areas;

public class CompaniesDTO {

	private int id;
	
	private String name;

	private String description;

    private Areas area;
    
	public CompaniesDTO() {
		
	}

	public CompaniesDTO(int id, String name, String description, Areas area) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.area = area;
	}

	public CompaniesDTO(String name, String description, Areas area) {
		super();
		this.name = name;
		this.description = description;
		this.area = area;
	}

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


	public Areas getArea() {
		return area;
	}


	public void setArea(Areas area) {
		this.area = area;
	}


	@Override
	public String toString() {
		return "CompaniesDTO [name=" + name + "]";
	}
}