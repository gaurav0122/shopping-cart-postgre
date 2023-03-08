package com.wallet.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class EWallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int walletId;
	
	private Double currentBalance;
	
	@Column(unique = true)
	private int userId;
	
	private String userName;
	

	public EWallet() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EWallet(int walletId, Double currentBalance, int userId, String userName) {
		super();
		this.walletId = walletId;
		this.currentBalance = currentBalance;
		this.userId = userId;
		this.userName = userName;
	}


	public int getWalletId() {
		return walletId;
	}


	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}


	public Double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	
	
	
	

}
