package com.cradletechnologies.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cradletechnologies.transportation.model.AuditIdentifier;

@Repository
public interface AuditIdentifierRepository extends JpaRepository< AuditIdentifier, Long>, JpaSpecificationExecutor<AuditIdentifier> {

}
