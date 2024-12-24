package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.PayBoxes;

public interface PayBoxesRepository extends JpaRepository<PayBoxes, Integer> , JpaSpecificationExecutor<PayBoxes>{


}
