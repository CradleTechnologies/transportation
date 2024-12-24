package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.Designations;

public interface DesignationsRepository extends JpaRepository<Designations, Integer> , JpaSpecificationExecutor<Designations>{
	
	
}
