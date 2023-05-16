package com.promineotech.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.entity.Transactions;
import com.promineotech.dao.TransactionsDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultTransactionsService implements TransactionsService {

	@Autowired
	private TransactionsDao transactionsDao;
	
	@Transactional(readOnly = true)
	public List<Transactions> fetchAllTransactions() {
		List<Transactions> transactions = transactionsDao.fetchAllTransactions();
		if(transactions.isEmpty()) {
			String msg = String.format("there are no transactions: to fix create a transaction.");
			throw new NoSuchElementException(msg);
		}
		return transactions;
	}

	@Override
	public void deleteTransaction(int transactionsId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
