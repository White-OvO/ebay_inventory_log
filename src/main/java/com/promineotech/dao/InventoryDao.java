package com.promineotech.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.entity.Category;
import com.promineotech.entity.Inventory;

public interface InventoryDao {

	
	 List<Inventory> fetchAllInventory();
	 //return inventoryService.fetchAllInventory();

	 
	 
	Inventory createInventory(Category category, int itemNumber,
				String itemName, int amountAvaliable, String sellerName);
	 
	 Inventory updateInventory(Category category, int itemNumber,
				String itemName, int amountAvaliable, String sellerName);
	 
	 
	 void deleteInventory(int inventoryId);


	
}
