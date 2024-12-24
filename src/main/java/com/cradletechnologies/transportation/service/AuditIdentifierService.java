package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.AuditIdentifier;

public interface AuditIdentifierService {

    List<AuditIdentifier> getAllAuditIdentifiers();

    void saveAuditIdentifier(AuditIdentifier auditIdentifier);

    AuditIdentifier getAuditIdentifier(long id);

    void deleteAuditIdentifier(long id);

    Page<AuditIdentifier> getAuditIdentifierForDatatable(String queryString, Pageable pageable);
}
