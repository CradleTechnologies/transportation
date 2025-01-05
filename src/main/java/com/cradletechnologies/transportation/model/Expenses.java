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
@Table(name = "expenses", catalog = "cradle_transport", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"expense_proof"})})
@XmlRootElement
@NamedQueries({
	@NamedQuery(name ="Expenses.findAll", query = "SELECT c FROM Expenses c"),
	@NamedQuery(name = "Expenses.findById", query = "SELECT c FROM Expenses c WHERE c.id = :id"),
	@NamedQuery(name = "Expenses.findByExpenseDate", query = "SELECT c FROM Expenses c WHERE c.expenseDate = :expenseDate"),
	@NamedQuery(name = "Expenses.findByAmountPaid", query = "SELECT c FROM Expenses c WHERE c.amountPaid = :amountPaid"),
	@NamedQuery(name = "Expenses.findByPaidFor", query = "SELECT c FROM Expenses c WHERE c.paidFor = :paidFor"),
	@NamedQuery(name = "Expenses.findByExpenseProof", query = "SELECT c FROM Expenses c WHERE c.expenseProof = :expenseProof")})

public class Expenses  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "expense_date", nullable = false, length = 200)
	private Date expenseDate;

	@Column(name = "amount_paid", nullable = false, length = 100)
	private Double amountPaid;
	
	@Column(name = "paid_for", nullable = false, length = 255)
	private String paidFor;
	
	@Column(name = "expense_proof", nullable = false, length = 255)
	private String expenseProof;
	
    @JoinColumn(name = "truck_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Trucks truck;
    
    @JoinColumn(name = "pay_box_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PayBoxes payBox;

    @JoinColumn(name = "audit_identifier_id", referencedColumnName = "identifier_id", nullable = false)
    @ManyToOne(optional = false)
    private AuditIdentifier auditIdentifierId;

	

    public Expenses() {
		
	}




	public Expenses(int id, Date expenseDate, Double amountPaid, String paidFor, String expenseProof, Trucks truck, PayBoxes payBox) {
		super();
		this.id = id;
		this.expenseDate = expenseDate;
		this.amountPaid = amountPaid;
		this.paidFor = paidFor;
		this.expenseProof = expenseProof;
		this.truck = truck;
		this.payBox = payBox;
	}




	public Expenses(Date expenseDate, Double amountPaid, String paidFor, String expenseProof, Trucks truck, PayBoxes payBox) {
		super();
		this.expenseDate = expenseDate;
		this.amountPaid = amountPaid;
		this.paidFor = paidFor;
		this.expenseProof = expenseProof;
		this.truck = truck;
		this.payBox = payBox;
	}



	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Date getExpenseDate() {
		return expenseDate;
	}




	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}




	public Double getAmountPaid() {
		return amountPaid;
	}




	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}




	public String getPaidFor() {
		return paidFor;
	}




	public void setPaidFor(String paidFor) {
		this.paidFor = paidFor;
	}




	public String getExpenseProof() {
		return expenseProof;
	}




	public void setExpenseProof(String expenseProof) {
		this.expenseProof = expenseProof;
	}




	public Trucks getTruck() {
		return truck;
	}




	public void setTruck(Trucks truck) {
		this.truck = truck;
	}




	public PayBoxes getPayBox() {
		return payBox;
	}




	public void setPayBox(PayBoxes payBox) {
		this.payBox = payBox;
	}




	public AuditIdentifier getAuditIdentifierId() {
		return auditIdentifierId;
	}




	public void setAuditIdentifierId(AuditIdentifier auditIdentifierId) {
		this.auditIdentifierId = auditIdentifierId;
	}

	
    
	@Transient
	public String getExpenseProofPath() {
		if(expenseProof == null || id == 0) return null;
		return "/expense-proofs/"+id+"/"+expenseProof;
	}

	//To String
	@Override
	public String toString() {
		return "Expenses [id=" + id + "]";
	}


}
