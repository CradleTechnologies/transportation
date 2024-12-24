package com.cradletechnologies.transportation.model;

import java.io.Serializable;
import java.sql.Date;

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
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="staffs", catalog="cradle_transport", schema="", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"staff_name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staffs.findAll", query = "SELECT s FROM Staffs s"),
    @NamedQuery(name = "Staffs.findById", query = "SELECT s FROM Staffs s WHERE s.id = :id"),
    @NamedQuery(name = "Staffs.findByFirstName", query = "SELECT s FROM Staffs s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Staffs.findByLastName", query = "SELECT s FROM Staffs s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Staffs.findByStaffName", query = "SELECT s FROM Staffs s WHERE s.staffName = :staffName"),
    @NamedQuery(name = "Staffs.findByIdNo", query = "SELECT s FROM Staffs s WHERE s.idNo = :idNo"),
    @NamedQuery(name = "Staffs.findByTelNo", query = "SELECT s FROM Staffs s WHERE s.telNo = :telNo"),
    @NamedQuery(name = "Staffs.findByEmail", query = "SELECT s FROM Staffs s WHERE s.email = :email"),
    @NamedQuery(name = "Staffs.findByGender", query = "SELECT s FROM Staffs s WHERE s.gender = :gender"),
    @NamedQuery(name = "Staffs.findByDetailedResidence", query = "SELECT s FROM Staffs s WHERE s.detailedResidence = :detailedResidence"),
    @NamedQuery(name = "Staffs.findByAchievements", query = "SELECT s FROM Staffs s WHERE s.achievements = :achievements"),
    @NamedQuery(name = "Staffs.findByScannedDocument", query = "SELECT s FROM Staffs s WHERE s.scannedDocument = :scannedDocument"),
    @NamedQuery(name = "Staffs.findByStaffPicture", query = "SELECT s FROM Staffs s WHERE s.staffPicture = :staffPicture"),
    @NamedQuery(name = "Staffs.findByDesignation", query = "SELECT s FROM Staffs s WHERE s.designation = :designation"),
    @NamedQuery(name = "Staffs.findByAreas", query = "SELECT s FROM Staffs s WHERE s.areas = :areas")})
public class Staffs implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="record_date", nullable=false)
	private Date recordDate;

	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="staff_name", nullable=false)
	private String staffName;

	@Column(name="id_no", nullable=false)
	private String idNo;
	
	@Column(name="tel_no", nullable=false)
	private String telNo;

	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="gender", nullable=false)
	private String gender;

	@Column(name="status", nullable=false)
	private String status;

	@Column(name="detailed_residence", nullable=false, length = 2000)
	private String detailedResidence;
	
	@Column(name="achievements", nullable=false)
	private String achievements;

	@Column(name="salary_amount", nullable=false)
	private Double salaryAmount;

	@Column(name="scanned_document", nullable=false, length = 255)
	private String scannedDocument;

	@Column(name = "staff_picture", nullable = true, length = 255)
	private String staffPicture;
	

    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Designations designation;

    @JoinColumn(name = "area_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Areas areas;
    
    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
    @ManyToOne(optional = false)
    private AuditIdentifier auditIdentifierId;

    //Constructors
    public Staffs() {
		
	}

	public Staffs(int id, Date recordDate, String firstName, String lastName, String staffName, String idNo,
			String telNo, String email, String gender, String status, String detailedResidence, String achievements,
			Double salaryAmount, String scannedDocument, String staffPicture, Designations designation, Areas areas) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.staffName = staffName;
		this.idNo = idNo;
		this.telNo = telNo;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.detailedResidence = detailedResidence;
		this.achievements = achievements;
		this.salaryAmount = salaryAmount;
		this.scannedDocument = scannedDocument;
		this.staffPicture = staffPicture;
		this.designation = designation;
		this.areas = areas;
	}

	public Staffs(Date recordDate, String firstName, String lastName, String staffName, String idNo, String telNo,
			String email, String gender, String status, String detailedResidence, String achievements,
			Double salaryAmount, String scannedDocument, String staffPicture, Designations designation, Areas areas) {
		super();
		this.recordDate = recordDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.staffName = staffName;
		this.idNo = idNo;
		this.telNo = telNo;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.detailedResidence = detailedResidence;
		this.achievements = achievements;
		this.salaryAmount = salaryAmount;
		this.scannedDocument = scannedDocument;
		this.staffPicture = staffPicture;
		this.designation = designation;
		this.areas = areas;
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

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetailedResidence() {
		return detailedResidence;
	}

	public void setDetailedResidence(String detailedResidence) {
		this.detailedResidence = detailedResidence;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	public Double getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(Double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public String getScannedDocument() {
		return scannedDocument;
	}

	public void setScannedDocument(String scannedDocument) {
		this.scannedDocument = scannedDocument;
	}

	public String getStaffPicture() {
		return staffPicture;
	}

	public void setStaffPicture(String staffPicture) {
		this.staffPicture = staffPicture;
	}

	public Designations getDesignation() {
		return designation;
	}

	public void setDesignation(Designations designation) {
		this.designation = designation;
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


	@Transient
	public String getStaffPicturePath() {
		if(staffPicture == null || id == 0) return null;
		return "/staff-pictures/"+id+"/"+staffPicture;
	}

	@Transient
	public String getScannedDocumentPath() {
		if(scannedDocument == null || id == 0) return null;
		return "/staff-scanned-documents/"+id+"/"+scannedDocument;
	}
	

	@Override
	public String toString() {
		return "Staffs [staffName=" + staffName + "]";
	}
    
}
