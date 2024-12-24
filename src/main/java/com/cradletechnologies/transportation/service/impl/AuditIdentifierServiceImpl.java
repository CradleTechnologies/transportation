package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.filter.AuditIdentifierDataFilter;
import com.cradletechnologies.transportation.model.AuditIdentifier;
import com.cradletechnologies.transportation.repository.AuditIdentifierRepository;
import com.cradletechnologies.transportation.service.AuditIdentifierService;

@Service
public class AuditIdentifierServiceImpl implements AuditIdentifierService {

    @Autowired
    private AuditIdentifierRepository auditIdentifierRepository;

    @Override
    public List<AuditIdentifier> getAllAuditIdentifiers() {
        return this.auditIdentifierRepository.findAll();
    }

    @Override
    public void saveAuditIdentifier(AuditIdentifier auditIdentifier) {
        this.auditIdentifierRepository.save(auditIdentifier);
    }

    @Override
    public AuditIdentifier getAuditIdentifier(long id) {

        Optional<AuditIdentifier> optional = auditIdentifierRepository.findById(id);
        AuditIdentifier auditIdentifier = null;
        if (optional.isPresent()) {
            auditIdentifier = optional.get();
        } else {
            throw new RuntimeException("ACL not found for id : " + id);
        }
        return auditIdentifier;

    }

    @Override
    public void deleteAuditIdentifier(long id) {
        this.auditIdentifierRepository.deleteById(id);
    }

    @Override
    public Page<AuditIdentifier> getAuditIdentifierForDatatable(String queryString, Pageable pageable) {
        AuditIdentifierDataFilter auditIdentifierDataFilter = new AuditIdentifierDataFilter(queryString);
        return auditIdentifierRepository.findAll(auditIdentifierDataFilter, pageable);
    }

}
