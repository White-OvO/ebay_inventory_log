package com.promineotech.service;

import java.util.List;

import com.promineotech.entity.Inventory;

public interface InventoryService {
// GETS
	
	
	public List<Inventory> fetchAllInventory() ;
	
	void deleteInventory(int inventoryId);
	
	Inventory createInventory(Enum Category, int itemNumber,
			String itemName, int amountAvaliable, String sellerName);

	Inventory updateInventory(int inventoryId,Enum Category, int itemNumber,
				String itemName, int amountAvaliable, String sellerName);
}
