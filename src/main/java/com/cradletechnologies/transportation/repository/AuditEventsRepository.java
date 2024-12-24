package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cradletechnologies.transportation.model.AuditEvents;


@Repository
public interface AuditEventsRepository extends JpaRepository<AuditEvents, Integer>, JpaSpecificationExecutor<AuditEvents> {

    
}
