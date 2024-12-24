package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.Companies;

public interface CompaniesRepository extends JpaRepository<Companies, Integer> , JpaSpecificationExecutor<Companies>{
	
	
}
