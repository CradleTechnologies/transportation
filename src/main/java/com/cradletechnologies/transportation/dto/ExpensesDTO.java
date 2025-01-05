package com.cradletechnologies.transportation.dto;

import java.sql.Date;

import jakarta.persistence.Transient;

public class ExpensesDTO {

	private int id;
	
	private Date expenseDate;

	private Double amountPaid;
	
	private String paidFor;
	
	private String expenseProof;
	
    private int truck;
    
    private int payBox;

    
    public ExpensesDTO() {
		
	}

	public ExpensesDTO(int id, Date expenseDate, Double amountPaid, String paidFor, String expenseProof, int truck, int payBox) {
		super();
		this.id = id;
		this.expenseDate = expenseDate;
		this.amountPaid = amountPaid;
		this.paidFor = paidFor;
		this.expenseProof = expenseProof;
		this.truck = truck;
		this.payBox = payBox;
	}

	public ExpensesDTO(Date expenseDate, Double amountPaid, String paidFor, String expenseProof, int truck, int payBox) {
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

	public int getTruck() {
		return truck;
	}

	public void setTruck(int truck) {
		this.truck = truck;
	}

	public int getPayBox() {
		return payBox;
	}


	public void setPayBox(int payBox) {
		this.payBox = payBox;
	}


    
	@Transient
	public String getExpenseProofPath() {
		if(expenseProof == null || id == 0) return null;
		return "/expense-proofs/"+id+"/"+expenseProof;
	}

	//To String
	@Override
	public String toString() {
		return "ExpensesDTO [id=" + id + "]";
	}


}
