package com.cradletechnologies.transportation.model;

import java.io.Serializable;

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
import jakarta.xml.bind.annotation.XmlRootElement;

//@Getter
//@Setter
@Entity
@Table(name = "companies", catalog = "cradle_transport", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companies.findAll", query = "SELECT c FROM Companies c"),
    @NamedQuery(name = "Companies.findById", query = "SELECT c FROM Companies c WHERE c.id = :id"),
    @NamedQuery(name = "Companies.findByName", query = "SELECT c FROM Companies c WHERE c.name = :name")})
public class Companies implements Serializable {

    private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = true, length = 1000)
	private String description;

	
    @JoinColumn(name = "area_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Areas area;
    
    
    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
    @ManyToOne(optional = false)
    private AuditIdentifier auditIdentifierId;
    
    
    //constructors
	public Companies() {
		
	}


	public Companies(int id, String name, String description, Areas area) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.area = area;
	}


	public Companies(String name, String description, Areas area) {
		super();
		this.name = name;
		this.description = description;
		this.area = area;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
		return "Companies [name=" + name + "]";
	}
}