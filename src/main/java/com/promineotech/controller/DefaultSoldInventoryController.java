package com.promineotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.entity.Category;
import com.promineotech.entity.Inventory;
import com.promineotech.entity.SoldInventory;
import com.promineotech.service.SoldInventoryService;

@RestController

public class DefaultSoldInventoryController implements SoldInventoryController{
	@Autowired
	
	private SoldInventoryService soldInventoryService;
	
	
	@Override
	public List<SoldInventory> fetchAllSoldInventory() { 
		return soldInventoryService.fetchAllSoldInventory();
		
	}
	
	
	
	
	
	
	
	@Override
	public SoldInventory soldInventory(int EbayOrderNumber, int transactionId,
			int itemNumber) {
		return soldInventoryService.createSoldInventory(EbayOrderNumber, transactionId,itemNumber);
	
	
	


}
}