package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.filter.CompaniesDataFilter;
import com.cradletechnologies.transportation.model.Companies;
import com.cradletechnologies.transportation.repository.CompaniesRepository;
import com.cradletechnologies.transportation.service.CompaniesService;

@Service
public class CompaniesServiceImpl implements CompaniesService{

	@Autowired
	private CompaniesRepository companiesRepository;

	@Override
	public List<Companies> getAllCompanies() {
		return this.companiesRepository.findAll();
	}

	@Override
	public Companies saveCompany(Companies company) {
		return this.companiesRepository.save(company);
		
	}

	@Override
	public Companies getCompany(int id) {
		Optional<Companies> optional = companiesRepository.findById(id);
		Companies company = null;
		if(optional.isPresent()) {
			company = optional.get();
		}
		else {
			throw new RuntimeException("Company not found for id : "+id);
		}
		return company;
	}


	@Override
	public void deleteCompany(int id) {
		this.companiesRepository.deleteById(id);
		
	}

	@Override
	public Page<Companies> getCompaniesForDatatable(String queryString, Pageable pageable) {
		CompaniesDataFilter companiesDataFilter = new CompaniesDataFilter(queryString);
		return companiesRepository.findAll(companiesDataFilter, pageable);
	}
	
	

}
