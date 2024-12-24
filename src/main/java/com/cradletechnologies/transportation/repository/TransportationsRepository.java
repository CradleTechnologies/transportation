package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.Transportations;

public interface TransportationsRepository extends JpaRepository<Transportations, Integer> , JpaSpecificationExecutor<Transportations>{


}
