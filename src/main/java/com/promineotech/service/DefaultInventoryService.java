package com.promineotech.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.dao.InventoryDao;
import com.promineotech.entity.Category;
import com.promineotech.entity.Customer;
import com.promineotech.entity.Inventory;
//import com.promineotech.dao.InventoryDao;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultInventoryService implements InventoryService {

	
	@Autowired
	private InventoryDao inventoryDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Inventory> fetchAllInventory() { 
		List<Inventory> inventory = inventoryDao.fetchAllInventory();
		if(inventory.isEmpty()) { 
			String msg = String.format("Add inventory");
			throw new NoSuchElementException(msg);
		}
		return inventory;
	}
	public Inventory createInventory(Category category, int itemNumber, String itemName, int amountAvaliable,
			String sellerName) {
		log.info("Creates inventory in Service");
		return inventoryDao.createInventory(category,itemNumber,itemName,amountAvaliable,sellerName);
		
	}

	@Override
	public Inventory updateInventory(int inventoryId,Category category, int itemNumber, String itemName, int amountAvaliable,
			String sellerName) {
		log.info("update inventory in the service ");
		return inventoryDao.updateInventory(category,inventoryId, sellerName,itemNumber,itemName);
	}

	@Override
	public void deleteInventory(int inventoryId) {
		log.info("delete method was cast upon your request", inventoryId);
		
		inventoryDao.deleteInventory(inventoryId);
	}

	
}
