package com.cradletechnologies.transportation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.model.AuditEvents;

public interface AuditEventsService {

    List<AuditEvents> getAllAuditEvents();

    void saveAuditEvents(AuditEvents auditEvents);

    AuditEvents getAuditEvent(int id);

    void deleteAuditEvent(int id);

    Page<AuditEvents> getAuditEventsForDatatable(String queryString, Pageable pageable);
}
