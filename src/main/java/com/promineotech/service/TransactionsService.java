package com.promineotech.service;

import java.util.List;

import com.promineotech.entity.Transactions;

public interface TransactionsService {

	
	
	
	public List<Transactions>fetchAllTransactions();
	
	
	
	void deleteTransaction(int transactionsId);
}
