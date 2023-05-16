package com.promineotech.dao;

import java.util.List;

import com.promineotech.entity.Inventory;

public interface InventoryDao {

	
	 List<Inventory> fetchAllInventory();
	 //return inventoryService.fetchAllInventory();

	 
	 
	 Inventory createInventory(Enum Category, int itemNumber,
				String itemName, int amountAvaliable, String sellerName);
	 
	 Inventory updateInventory(int inventoryId,Enum Category, int itemNumber,
				String itemName, int amountAvaliable, String sellerName);
	 
	 
	 void deleteInventory(int inventoryId);
	
	
}
