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
@Table(name = "designations", catalog = "cradle_transport", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Designations.findAll", query = "SELECT d FROM Designations d"),
    @NamedQuery(name = "Designations.findById", query = "SELECT d FROM Designations d WHERE d.id = :id"),
    @NamedQuery(name = "Designations.findByName", query = "SELECT d FROM Designations d WHERE d.name = :name")})
public class Designations implements Serializable {

    private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = true, length = 1000)
	private String description;


    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
    @ManyToOne(optional = false)
    private AuditIdentifier auditIdentifierId;
    
    
    //constructors
	public Designations() {
		
	}
    
	public Designations(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	
	public Designations(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	//getters and setters
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

	public AuditIdentifier getAuditIdentifierId() {
		return auditIdentifierId;
	}

	public void setAuditIdentifierId(AuditIdentifier auditIdentifierId) {
		this.auditIdentifierId = auditIdentifierId;
	}

	@Override
	public String toString() {
		return "Designations [name=" + name + "]";
	}
	
	
}
