package com.wallet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wallet.api.model.EWallet;
import com.wallet.api.model.Statement;

@Repository
public interface EWalletRepository extends JpaRepository<EWallet,Integer> {

	EWallet findByUserId(int userId);


	
}
