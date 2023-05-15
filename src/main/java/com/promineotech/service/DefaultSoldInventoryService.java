package com.promineotech.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.entity.SoldInventory;
//import com.promineotech.dao.SoldInventoryDao;
import com.promineotech.dao.SoldInventoryDao;
@Service


public class DefaultSoldInventoryService implements SoldInventoryService {

	
	@Autowired
	private SoldInventoryDao soldInventoryDao;
	
	
	@Transactional
	//@Override
	
	/// CRUD GET 
	public List<SoldInventory> fetchAllSoldInventory() { 
		List<SoldInventory> soldInventory = soldInventoryDao.fetchAllSoldInventory();
		if(soldInventory.isEmpty()) { 
			String msg = String.format("There are no oders as if this moment"); 
			throw new NoSuchElementException(msg);
			
		}
		return soldInventory;
	}
}
