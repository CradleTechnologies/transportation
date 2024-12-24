package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.filter.AuditEventsDataFilter;
import com.cradletechnologies.transportation.model.AuditEvents;
import com.cradletechnologies.transportation.repository.AuditEventsRepository;
import com.cradletechnologies.transportation.repository.UserRepository;
import com.cradletechnologies.transportation.security.UserPrincipal;
import com.cradletechnologies.transportation.service.AuditEventsService;

@Service
public class AuditEventsServiceImpl implements AuditEventsService {

    @Autowired
    private AuditEventsRepository auditEventsRepository;
    
    @Autowired
    private UserRepository usersRepository;

    @Override
    public List<AuditEvents> getAllAuditEvents() {
        return this.auditEventsRepository.findAll();
    }

    @Override
    public void saveAuditEvents(AuditEvents auditEvents) {
        UserPrincipal cradleUserDetails = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();        
        auditEvents.setUserId(usersRepository.findByUsername(cradleUserDetails.getUsername()));
        this.auditEventsRepository.save(auditEvents);
    }

    @Override
    public AuditEvents getAuditEvent(int id) {
        Optional<AuditEvents> optional = auditEventsRepository.findById(id);
        AuditEvents auditEvents = null;
        if (optional.isPresent()) {
            auditEvents = optional.get();
        } else {
            throw new RuntimeException("AuditEvents not found for id : " + id);
        }
        return auditEvents;
    }

    @Override
    public void deleteAuditEvent(int id) {
        this.auditEventsRepository.deleteById(id);
    }

    @Override
    public Page<AuditEvents> getAuditEventsForDatatable(String queryString, Pageable pageable) {
        AuditEventsDataFilter auditEventsDataFilter = new AuditEventsDataFilter(queryString);
        return auditEventsRepository.findAll(auditEventsDataFilter, pageable);
    }

}

