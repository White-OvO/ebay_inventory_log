package com.promineotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.entity.Category;
import com.promineotech.entity.Inventory;
import com.promineotech.entity.Transactions;
//import com.promineotech.Service.TransactionsService;
import com.promineotech.service.TransactionsService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultTransactionsController implements transactionsController{
	
	@Autowired
	
	private TransactionsService transactionsService;
	
	
	@Override
	
	public List<Transactions> fetchAllTransactions(){
		return transactionsService.fetchAllTransactions();
	}
	@Override
	public  Transactions createTransactions(int transactionsId, int customerId, String dateSold, int taxesPerTransaction,
			int shippingCost, int sellerFee) {
		return transactionsService.createTransactions(transactionsId, customerId, dateSold, taxesPerTransaction,
shippingCost, sellerFee);
	}
	@Override
	public void deleteTransactions(int transactionsId) {
		log.debug("transactionsId={}", transactionsId);
		inventoryService.deletetransactions(transactionsId);

	}
}
