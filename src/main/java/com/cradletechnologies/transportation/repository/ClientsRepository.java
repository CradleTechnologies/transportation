package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cradletechnologies.transportation.model.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Integer> , JpaSpecificationExecutor<Clients>{
	
}
