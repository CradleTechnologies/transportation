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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "transportations", catalog = "cradle_transport", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportations.findAll", query = "SELECT t FROM Transportations t"),
    @NamedQuery(name = "Transportations.findById", query = "SELECT t FROM Transportations t WHERE t.id = :id")})
public class Transportations implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(nullable = false)
	    private int id;

		@Column(name = "transport_date", nullable = false, length = 200)
		private Date transportDate;
		
		@Column(name = "off_loading_date", nullable = false, length = 200)
		private Date offLoadingDate;
		
		@Column(name = "status", nullable = false, length = 200)
		private String status;

	   
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "transport_charges", nullable = false)
	    private Double transportCharges;
	    
	    @JoinColumn(name = "truck_id", referencedColumnName = "id", nullable = false)
	    @ManyToOne(optional = false)
	    private Trucks truck;
	    
	    
	    @JoinColumn(name = "area_id", referencedColumnName = "id", nullable = false)
	    @ManyToOne(optional = false)
	    private Areas area;
	    
	    
	    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
	    @ManyToOne(optional = false)
	    private Clients client;
	    
	    
	    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
	    @ManyToOne(optional = false)
	    private AuditIdentifier auditIdentifierId;
	    
		 public Transportations() {			
			}

		public Transportations(int id, Date transportDate, Date offLoadingDate, String status,
				@NotNull Double transportCharges, Trucks truck, Areas area, Clients client) {
			super();
			this.id = id;
			this.transportDate = transportDate;
			this.offLoadingDate = offLoadingDate;
			this.status = status;
			this.transportCharges = transportCharges;
			this.truck = truck;
			this.area = area;
			this.client = client;
		}

		public Transportations(Date transportDate, Date offLoadingDate, String status, @NotNull Double transportCharges,
				Trucks truck, Areas area, Clients client) {
			super();
			this.transportDate = transportDate;
			this.offLoadingDate = offLoadingDate;
			this.status = status;
			this.transportCharges = transportCharges;
			this.truck = truck;
			this.area = area;
			this.client = client;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getTransportDate() {
			return transportDate;
		}

		public void setTransportDate(Date transportDate) {
			this.transportDate = transportDate;
		}

		public Date getOffLoadingDate() {
			return offLoadingDate;
		}

		public void setOffLoadingDate(Date offLoadingDate) {
			this.offLoadingDate = offLoadingDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Double getTransportCharges() {
			return transportCharges;
		}

		public void setTransportCharges(Double transportCharges) {
			this.transportCharges = transportCharges;
		}

		public Trucks getTruck() {
			return truck;
		}

		public void setTruck(Trucks truck) {
			this.truck = truck;
		}

		public Areas getArea() {
			return area;
		}

		public void setArea(Areas area) {
			this.area = area;
		}

		public Clients getClient() {
			return client;
		}

		public void setClient(Clients client) {
			this.client = client;
		}

		public AuditIdentifier getAuditIdentifierId() {
			return auditIdentifierId;
		}

		public void setAuditIdentifierId(AuditIdentifier auditIdentifierId) {
			this.auditIdentifierId = auditIdentifierId;
		}

		@Override
		public String toString() {
			return "Transportations [transportDate=" + transportDate + ", status=" + status + ", transportCharges="
					+ transportCharges + ", truck=" + truck + ", area=" + area + ", client=" + client + "]";
		}
		 
}