package com.cradletechnologies.transportation.model;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(catalog = "cradle_transport", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email_address"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
    @NamedQuery(name = "Clients.findByFirstName", query = "SELECT c FROM Clients c WHERE c.firstName = :firstName"),
	@NamedQuery(name = "Clients.findByLastName", query = "SELECT c FROM Clients c WHERE c.lastName = :lastName"),
	@NamedQuery(name = "Clients.findByTelNo", query = "SELECT c FROM Clients c WHERE c.telNo = :telNo"),
	@NamedQuery(name = "Clients.findByStatus", query = "SELECT c FROM Clients c WHERE c.status = :status"),
	@NamedQuery(name = "Clients.findByEmailAddress", query = "SELECT c FROM Clients c WHERE c.emailAddress = :emailAddress"),
	})
public class Clients implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(nullable = false)
	    private int id;

	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 255)
	    @Column(name = "first_name", nullable = false, length = 255)
	    private String firstName;


	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 255)
	    @Column(name = "last_name", nullable = false, length = 255)
	    private String lastName;
	    
	    
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 255)
	    @Column(name = "client_name", nullable = false, length = 255)
	    private String clientName;
	    

	    @Basic(optional = false)
	    @Size(min = 1, max = 400)
	    @Column(name = "email_address", length = 400)
	    private String emailAddress;

	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 100)
	    @Column(name = "tel_no", nullable = false, length = 100)
	    private String telNo;
	    
	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 100)
	    @Column(name = "status", nullable = false, length = 100)
	    private String status;

	    @JoinColumn(name = "area_id", referencedColumnName = "id", nullable = false)
	    @ManyToOne(optional = false)
	    private Areas areas;

	    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
	    @ManyToOne(optional = false)
	    private AuditIdentifier auditIdentifierId;
	    
    
		public Clients() {
			
		}
			
		public Clients(int id) {
			super();
			this.id = id;
		}
    	
		public Clients(int id, @NotNull @Size(min = 1, max = 255) String firstName,
				@NotNull @Size(min = 1, max = 255) String lastName,
				@NotNull @Size(min = 1, max = 255) String clientName, @Size(min = 1, max = 400) String emailAddress,
				@NotNull @Size(min = 1, max = 100) String telNo, @NotNull @Size(min = 1, max = 100) String status,
				Areas areas) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.clientName = clientName;
			this.emailAddress = emailAddress;
			this.telNo = telNo;
			this.status = status;
			this.areas = areas;
		}

		public Clients(@NotNull @Size(min = 1, max = 255) String firstName,
				@NotNull @Size(min = 1, max = 255) String lastName,
				@NotNull @Size(min = 1, max = 255) String clientName, @Size(min = 1, max = 400) String emailAddress,
				@NotNull @Size(min = 1, max = 100) String telNo, @NotNull @Size(min = 1, max = 100) String status,
				Areas areas) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.clientName = clientName;
			this.emailAddress = emailAddress;
			this.telNo = telNo;
			this.status = status;
			this.areas = areas;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getClientName() {
			return clientName;
		}

		public void setClientName(String clientName) {
			this.clientName = clientName;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getTelNo() {
			return telNo;
		}

		public void setTelNo(String telNo) {
			this.telNo = telNo;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Areas getAreas() {
			return areas;
		}

		public void setAreas(Areas areas) {
			this.areas = areas;
		}

		public AuditIdentifier getAuditIdentifierId() {
			return auditIdentifierId;
		}

		public void setAuditIdentifierId(AuditIdentifier auditIdentifierId) {
			this.auditIdentifierId = auditIdentifierId;
		}

		//check out
	    @Override
	    public String toString() {
	        return "Clients[ id=" + id + " ]";
	    }

}
