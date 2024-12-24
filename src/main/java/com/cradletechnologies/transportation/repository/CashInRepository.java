package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.CashIn;

public interface CashInRepository extends JpaRepository<CashIn, Integer>, JpaSpecificationExecutor<CashIn>{

}
