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
@Table(name = "areas", catalog = "cradle_transport", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"area_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a"),
    @NamedQuery(name = "Areas.findById", query = "SELECT a FROM Areas a WHERE a.id = :id"),
    @NamedQuery(name = "Areas.findByAreaCode", query = "SELECT a FROM Areas a WHERE a.areaCode = :areaCode"),
	@NamedQuery(name = "Areas.findByAreaName", query = "SELECT a FROM Areas a WHERE a.areaName = :areaName")})
public class Areas implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(nullable = false)
	    private int id;

	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 400)
	    @Column(name = "area_code", nullable = false, length = 400)
	    private String areaCode;


	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 400)
	    @Column(name = "area_name", nullable = false, length = 400)
	    private String areaName;
	    
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "transport_charges", nullable = false)
	    private Double transportCharges;
	    
	    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
	    @ManyToOne(optional = false)
	    private AuditIdentifier auditIdentifierId;
	    
		 public Areas() {			
			}

		public Areas(int id, @NotNull @Size(min = 1, max = 400) String areaCode,
				@NotNull @Size(min = 1, max = 400) String areaName, @NotNull Double transportCharges) {
			super();
			this.id = id;
			this.areaCode = areaCode;
			this.areaName = areaName;
			this.transportCharges = transportCharges;
		}

		public Areas(@NotNull @Size(min = 1, max = 400) String areaCode,
				@NotNull @Size(min = 1, max = 400) String areaName, @NotNull Double transportCharges) {
			super();
			this.areaCode = areaCode;
			this.areaName = areaName;
			this.transportCharges = transportCharges;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getAreaCode() {
			return areaCode;
		}

		public void setAreaCode(String areaCode) {
			this.areaCode = areaCode;
		}

		public String getAreaName() {
			return areaName;
		}

		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}

		public Double getTransportCharges() {
			return transportCharges;
		}

		public void setTransportCharges(Double transportCharges) {
			this.transportCharges = transportCharges;
		}

		public AuditIdentifier getAuditIdentifierId() {
			return auditIdentifierId;
		}

		public void setAuditIdentifierId(AuditIdentifier auditIdentifierId) {
			this.auditIdentifierId = auditIdentifierId;
		}

		@Override
		public String toString() {
			return "Areas [id=" + id + ", areaName=" + areaName + "]";
		}		 
		 
}
