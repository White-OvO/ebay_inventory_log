package com.promineotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.entity.Category;
import com.promineotech.entity.Customer;
import com.promineotech.entity.Inventory;
import com.promineotech.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j



public class DefaultInventoryController implements InventoryController{

	
	@Autowired
	
	private InventoryService inventoryService;

	
	@Override
	
	public List<Inventory> fetchAllInventory(){
		return inventoryService.fetchAllInventory();
	}


	@Override
	public Inventory createInventory(Category category, int itemNumber,
			String itemName, int amountAvaliable, String sellerName) {
		return inventoryService.createInventory(category, itemNumber, itemName, amountAvaliable, sellerName);
	}

	



	@Override
	public Inventory updateInventory(int inventoryId, Category category, int itemNumber,
	String itemName, int amountAvaliable, String sellerName) {
		return inventoryService.updateInventory(inventoryId,category,itemNumber,itemName,amountAvaliable,sellerName);

	}


	@Override
	public void deleteInventory(int inventoryId) {
		log.debug("inventoryId={}", inventoryId);
		inventoryService.deleteInventory(inventoryId);

	}








}

	
	
