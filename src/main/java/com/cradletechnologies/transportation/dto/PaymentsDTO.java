package com.cradletechnologies.transportation.dto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;

public class PaymentsDTO {

	private int id;
	
	private Date paymentDate;

	@Column(name = "amount_paid", nullable = false, length = 100)
	private Double amountPaid;
	
	private String paidBy;
	
	private String paymentProof;
	
    private int client;

    private int payBox;

	

    public PaymentsDTO() {
		
	}



	public PaymentsDTO(int id, Date paymentDate, Double amountPaid, String paidBy, String paymentProof, int client,
			int payBox) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.amountPaid = amountPaid;
		this.paidBy = paidBy;
		this.paymentProof = paymentProof;
		this.client = client;
		this.payBox = payBox;
	}
	


	public PaymentsDTO(Date paymentDate, Double amountPaid, String paidBy, String paymentProof, int client,
			int payBox) {
		super();
		this.paymentDate = paymentDate;
		this.amountPaid = amountPaid;
		this.paidBy = paidBy;
		this.paymentProof = paymentProof;
		this.client = client;
		this.payBox = payBox;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getPaymentDate() {
		return paymentDate;
	}



	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}



	public Double getAmountPaid() {
		return amountPaid;
	}



	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}



	public String getPaidBy() {
		return paidBy;
	}



	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}



	public String getPaymentProof() {
		return paymentProof;
	}



	public void setPaymentProof(String paymentProof) {
		this.paymentProof = paymentProof;
	}



	public int getClient() {
		return client;
	}



	public void setClient(int client) {
		this.client = client;
	}



	public int getPayBox() {
		return payBox;
	}



	public void setPayBox(int payBox) {
		this.payBox = payBox;
	}



	@Transient
	public String getPaymentProofPath() {
		if(paymentProof == null || id == 0) return null;
		return "/payment-proofs/"+id+"/"+paymentProof;
	}


	@Override
	public String toString() {
		return "PaymentsDTO [id=" + id + "]";
	}


}
