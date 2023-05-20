package com.promineotech.service;

import java.util.List;

import com.promineotech.entity.Transactions;

public interface TransactionsService {

	
	
	
	public List<Transactions>fetchAllTransactions();
	
	
	
	//void deleteTransaction(int transactionsId,int customerId, String dateSold,int buyerPaid, int taxesPerTransaction, int shippingCost, int sellerFee);



	void deleteTransaction(int transactionsId);


}
