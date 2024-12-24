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
@Table(name = "trucks", catalog = "cradle_transport", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"registration_no"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trucks.findAll", query = "SELECT t FROM Trucks t"),
    @NamedQuery(name = "Trucks.findById", query = "SELECT t FROM Trucks t WHERE t.id = :id"),
    @NamedQuery(name = "Trucks.findByRegistrationNo", query = "SELECT t FROM Trucks t WHERE t.registrationNo = :registrationNo")})
public class Trucks implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(nullable = false)
	    private int id;

	    @Basic(optional = false)
	    @NotNull
	    @Size(min = 1, max = 400)
	    @Column(name = "registration_no", nullable = false, length = 400)
	    private String registrationNo;
	   
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "capacity", nullable = false)
	    private Double capacity;
	    
	    @Basic(optional = false)
	    @NotNull
	    @Column(name = "description", nullable = false, length=1000)
	    private String description;
	    
	    @JoinColumn(name = "staff_id", referencedColumnName = "id", nullable = false)
	    @ManyToOne(optional = false)
	    private Staffs staff;
 
	    
	    @JoinColumn(name = "area_id", referencedColumnName = "id", nullable = false)
	    @ManyToOne(optional = false)
	    private Areas area;
	    
	    
	    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
	    @ManyToOne(optional = false)
	    private AuditIdentifier auditIdentifierId;


		public Trucks() {

		}


		public Trucks(int id, @NotNull @Size(min = 1, max = 400) String registrationNo, @NotNull Double capacity,
				@NotNull String description, Staffs staff, Areas area) {
			super();
			this.id = id;
			this.registrationNo = registrationNo;
			this.capacity = capacity;
			this.description = description;
			this.staff = staff;
			this.area = area;
		}


		public Trucks(@NotNull @Size(min = 1, max = 400) String registrationNo, @NotNull Double capacity,
				@NotNull String description, Staffs staff, Areas area) {
			super();
			this.registrationNo = registrationNo;
			this.capacity = capacity;
			this.description = description;
			this.staff = staff;
			this.area = area;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getRegistrationNo() {
			return registrationNo;
		}


		public void setRegistrationNo(String registrationNo) {
			this.registrationNo = registrationNo;
		}


		public Double getCapacity() {
			return capacity;
		}


		public void setCapacity(Double capacity) {
			this.capacity = capacity;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public Staffs getStaff() {
			return staff;
		}


		public void setStaff(Staffs staff) {
			this.staff = staff;
		}


		public Areas getArea() {
			return area;
		}


		public void setArea(Areas area) {
			this.area = area;
		}


		public AuditIdentifier getAuditIdentifierId() {
			return auditIdentifierId;
		}


		public void setAuditIdentifierId(AuditIdentifier auditIdentifierId) {
			this.auditIdentifierId = auditIdentifierId;
		}


		@Override
		public String toString() {
			return "Trucks [registrationNo=" + registrationNo + ", description=" + description + "]";
		}
}
	    
	    
	    