package com.wallet.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Statement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String transactionType;
	
	private Double amount;
	
	private LocalDate date;

	private int orderId;
	
	private String transactionRemarks;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "eid")
	private EWallet eWallet;
	

	public Statement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Statement(int statementId, String transactionType, Double amount, LocalDate date, int orderId,
			String transactionRemarks, EWallet ewallet) {
		super();
		this.id = statementId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.orderId = orderId;
		this.transactionRemarks = transactionRemarks;
		this.eWallet = ewallet;
	}


	public int getStatementId() {
		return id;
	}


	public void setStatementId(int statementId) {
		this.id = statementId;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getTransactionRemarks() {
		return transactionRemarks;
	}


	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}

	public EWallet getEwallet() {
		return eWallet;
	}

	public void setEwallet(EWallet ewallet) {
		this.eWallet = ewallet;
	}


	@Override
	public String toString() {
		return "Statement [statementId=" + id + ", transactionType=" + transactionType + ", amount=" + amount
				+ ", date=" + date + ", orderId=" + orderId + ", transactionRemarks=" + transactionRemarks + "]";
	}

	
}
