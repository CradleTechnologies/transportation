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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cash_out", catalog = "cradle_transport", schema = "")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CashOut.findAll", query = "SELECT c FROM CashOut c"),
    @NamedQuery(name = "CashOut.findById", query = "SELECT c FROM CashOut c WHERE c.id = :id"),
    @NamedQuery(name = "CashOut.findByInititials", query = "SELECT c FROM CashOut c WHERE c.initials = :initials"),
	@NamedQuery(name = "CashOut.findByName", query = "SELECT c FROM CashOut c WHERE c.name = :name")})*/
public class CashOut implements Serializable {

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
	    @Column(name = "amount", nullable = false, length = 400)
	    private Double amount;

	    @Column(name = "remarks", nullable = true, length = 1000)
	    private String remarks;


	    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
	    @ManyToOne(optional = false)
	    private Clients client;

	    @JoinColumn(name = "designation_id", referencedColumnName = "id", nullable = false)
	    @ManyToOne(optional = false)
	    private Designations designation;

	    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
	    @ManyToOne(optional = false)
	    private AuditIdentifier auditIdentifierId;

	    //Constructors
		public CashOut() {
			
		}

		public CashOut(int id, @NotNull @Size(min = 1, max = 400) Date recordDate,
				@NotNull @Size(min = 1, max = 400) Double amount, String remarks, Clients client, Designations designation) {
			super();
			this.id = id;
			this.recordDate = recordDate;
			this.amount = amount;
			this.remarks = remarks;
			this.client = client;
			this.designation = designation;
		}

		public CashOut(@NotNull @Size(min = 1, max = 400) Date recordDate,
				@NotNull @Size(min = 1, max = 400) Double amount, String remarks, Clients client, Designations designation) {
			super();
			this.recordDate = recordDate;
			this.amount = amount;
			this.remarks = remarks;
			this.client = client;
			this.designation = designation;
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

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public Clients getClients() {
			return client;
		}

		public void setClients(Clients client) {
			this.client = client;
		}

		public Designations getDesignation() {
			return designation;
		}

		public void setDesignation(Designations designation) {
			this.designation = designation;
		}

		public AuditIdentifier getAuditIdentifierId() {
			return auditIdentifierId;
		}

		public void setAuditIdentifierId(AuditIdentifier auditIdentifierId) {
			this.auditIdentifierId = auditIdentifierId;
		}

		@Override
		public String toString() {
			return "CashOut [id=" + id + ", amount=" + amount + ", client=" + client + ", designation=" + designation + "]";
		}
		
		

	    
}
