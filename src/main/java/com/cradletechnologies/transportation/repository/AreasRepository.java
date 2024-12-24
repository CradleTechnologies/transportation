package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.Areas;

public interface AreasRepository extends JpaRepository<Areas, Integer> , JpaSpecificationExecutor<Areas>{
	

}
