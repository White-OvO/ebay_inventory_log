package com.promineotech.dao;

import java.util.List;

import com.promineotech.entity.Customer;
import com.promineotech.entity.SoldInventory;

public interface SoldInventoryDao {

	
	
	// CRUD reads sold inventory
	public List<SoldInventory> fetchAllSoldInventory();
	
	
	SoldInventory createSoldInventory(int EbayOrderNumber, int transactionId,
			int itemNumber);
	
}
