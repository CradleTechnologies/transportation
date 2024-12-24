package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.Companies;

public interface CompaniesService {
	
	List<Companies> getAllCompanies();
	
	Companies saveCompany(Companies client);
	
	Companies getCompany(int id);
	
	void deleteCompany(int id);
	
	Page<Companies> getCompaniesForDatatable(String queryString, Pageable pageable);

}
