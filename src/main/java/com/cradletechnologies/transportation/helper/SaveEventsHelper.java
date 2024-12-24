package com.cradletechnologies.transportation.helper;

import java.util.Date;

import com.cradletechnologies.transportation.model.AuditEvents;
import com.cradletechnologies.transportation.model.AuditIdentifier;
import com.cradletechnologies.transportation.model.AuditTypes;

import jakarta.persistence.Entity;

@Entity
public class SaveEventsHelper extends AuditEvents {

	
    public SaveEventsHelper() {
		super();
		
	}

	public SaveEventsHelper(Date eventDate, String description, String ipAddress, String browser, AuditIdentifier auditIdentifier, AuditTypes auditType) {
        super(eventDate, description, ipAddress, browser);
        super.setAuditIdentifierId(auditIdentifier);
        super.setAuditTypeId(auditType);
    }

}
