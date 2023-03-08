package com.wallet.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wallet.api.model.EWallet;
import com.wallet.api.model.Statement;

@Service
public interface EWalletService {
	
	public List<EWallet> getWallets();
	
	public EWallet addWallet(EWallet ewallet, int userId);
	
	public EWallet addMoney(int walletId,Double amount);
	
	public EWallet getById(int walletId);
	
	public List<Statement> getStatements();
	
	public List<Statement> getStatementByWalletId(int walletId);
	
	public String deleteById(int walletId);
	
	public EWallet getWalletByUserId(int userId);
	
	public EWallet payMoney(int walletIdSender,Double amount,int walletIdRecipent) throws Exception;

	public EWallet payMoney(int senderId, double amount) throws Exception;

}
