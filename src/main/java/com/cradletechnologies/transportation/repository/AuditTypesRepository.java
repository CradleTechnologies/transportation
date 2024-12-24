package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cradletechnologies.transportation.model.AuditTypes;

@Repository
public interface AuditTypesRepository extends JpaRepository<AuditTypes, Long>, JpaSpecificationExecutor<AuditTypes> {

    AuditTypes findByName(String name);
}
