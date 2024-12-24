package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cradletechnologies.transportation.model.CashOut;

@Repository
public interface CashOutRepository extends JpaRepository<CashOut, Integer>, JpaSpecificationExecutor<CashOut>{

}
