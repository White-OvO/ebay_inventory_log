package com.promineotech.service;

import java.util.List;

import com.promineotech.entity.Inventory;
import com.promineotech.entity.SoldInventory;

//import com.promineotech.EbayClient.entity.Sold_Inventory;

public interface SoldInventoryService {
//CRUD Gets Inventoy
	public List<SoldInventory> fetchAllSoldInventory() ;

	public SoldInventory createSoldInventory(int EbayOrderNumber, int transactionId, int itemNumber);
	
	
	
}
