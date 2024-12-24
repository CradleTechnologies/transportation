package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> , JpaSpecificationExecutor<Payments>{


}
