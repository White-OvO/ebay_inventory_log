package com.promineotech.dao;

import java.util.List;

import com.promineotech.entity.Transactions;

public interface TransactionsDao {

	
	
// CRUD read for 
	public  List<Transactions> fetchAllTransactions();


	Transactions createTransactions(int customerId, String dateSold, int buyerPaid, int taxesPerTransaction,
			int shippingCost, int sellerFee);

	
	
	
	public void deleteTransactions(int transactionsId);







}
