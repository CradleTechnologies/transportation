package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.Trucks;

public interface TrucksRepository extends JpaRepository<Trucks, Integer> , JpaSpecificationExecutor<Trucks>{


}
