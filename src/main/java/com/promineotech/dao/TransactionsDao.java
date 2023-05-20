package com.promineotech.dao;

import java.util.List;

import com.promineotech.entity.Transactions;

public interface TransactionsDao {

	
	
// CRUD read for 
	public  List<Transactions> fetchAllTransactions();

	public Transactions createtransactions(int transactionsId, int customerId, String dateSold, int taxesPerTransaction,
			int shippingCost, int sellerFee);

	public void deleteTransations(int transactionsId);
	
}
