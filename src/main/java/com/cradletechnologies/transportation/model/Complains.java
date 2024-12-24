package com.cradletechnologies.transportation.model;

import java.io.Serializable;
import java.sql.Date;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "complains", catalog = "cradle_transport", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complains.findAll", query = "SELECT c FROM Complains c"),
    @NamedQuery(name = "Complains.findById", query = "SELECT c FROM Complains c WHERE c.id = :id"),
    @NamedQuery(name = "Complains.findByComplainant", query = "SELECT c FROM Complains c WHERE c.complainant = :complainant"),
    @NamedQuery(name = "Complains.findByTelNo", query = "SELECT c FROM Complains c WHERE c.telNo = :telNo"),
    @NamedQuery(name = "Complains.findByAddressee", query = "SELECT c FROM Complains c WHERE c.addressee = :addressee"),
    @NamedQuery(name = "Complains.findByDetails", query = "SELECT c FROM Complains c WHERE c.details = :details"),
    @NamedQuery(name = "Complains.findByStatus", query = "SELECT c FROM Complains c WHERE c.status = :status")})
public class Complains implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(nullable = false)
	    private int id;

	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "record_date", nullable = false, length = 400)
	    private Date recordDate;

	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 400)
	    @Column(name = "complainant", nullable = false, length = 400)
	    private String complainant;

	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 400)
	    @Column(name = "tel_no", nullable = false, length = 400)
	    private String telNo;

	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 400)
	    @Column(name = "addressee", nullable = false, length = 400)
	    private String addressee;

	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 1000)
	    @Column(name = "details", nullable = false, length = 1000)
	    private String details;

	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 400)
	    @Column(name = "status", nullable = false, length = 400)
	    private String status;

	    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
	    @ManyToOne(optional = false)
	    private AuditIdentifier auditIdentifierId;

	    
		
		//Constructors
		public Complains() {
			
		}

		public Complains(int id, @NotNull @Size(min = 1, max = 400) Date recordDate,
				@NotNull @Size(min = 1, max = 400) String complainant, @NotNull @Size(min = 1, max = 400) String telNo,
				@NotNull @Size(min = 1, max = 400) String addressee, @NotNull @Size(min = 1, max = 1000) String details,
				@NotNull @Size(min = 1, max = 400) String status) {
			super();
			this.id = id;
			this.recordDate = recordDate;
			this.complainant = complainant;
			this.telNo = telNo;
			this.addressee = addressee;
			this.details = details;
			this.status = status;
		}

		public Complains(@NotNull @Size(min = 1, max = 400) Date recordDate,
				@NotNull @Size(min = 1, max = 400) String complainant, @NotNull @Size(min = 1, max = 400) String telNo,
				@NotNull @Size(min = 1, max = 400) String addressee, @NotNull @Size(min = 1, max = 1000) String details,
				@NotNull @Size(min = 1, max = 400) String status) {
			super();
			this.recordDate = recordDate;
			this.complainant = complainant;
			this.telNo = telNo;
			this.addressee = addressee;
			this.details = details;
			this.status = status;
		}

		
		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}

		public Date getRecordDate() {
			return recordDate;
		}

		public void setRecordDate(Date recordDate) {
			this.recordDate = recordDate;
		}

		public String getComplainant() {
			return complainant;
		}



		public void setComplainant(String complainant) {
			this.complainant = complainant;
		}



		public String getTelNo() {
			return telNo;
		}



		public void setTelNo(String telNo) {
			this.telNo = telNo;
		}



		public String getAddressee() {
			return addressee;
		}



		public void setAddressee(String addressee) {
			this.addressee = addressee;
		}



		public String getDetails() {
			return details;
		}



		public void setDetails(String details) {
			this.details = details;
		}



		public String getStatus() {
			return status;
		}



		public void setStatus(String status) {
			this.status = status;
		}



		public AuditIdentifier getAuditIdentifierId() {
			return auditIdentifierId;
		}



		public void setAuditIdentifierId(AuditIdentifier auditIdentifierId) {
			this.auditIdentifierId = auditIdentifierId;
		}



		@Override
		public String toString() {
			return "Complains [id=" + id + ", complainant=" + complainant + ", addressee=" + addressee + ", status="
					+ status + "]";
		}

		
}
