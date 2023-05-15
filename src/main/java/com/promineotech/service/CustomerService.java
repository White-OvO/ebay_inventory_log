package com.promineotech.service;

import java.util.List;

import com.promineotech.entity.Customer;

public interface CustomerService {
/// CRUD READ
	
	
	List<Customer> fetchAllCustomers();
	
// CRUD DELETE	
	
	void deleteCustomer(int customerId);
	
	//CRUD CREATE
	
	
	Customer createCustomer(String EbayUsername);
	
	// CRUD UPDATE
	Customer updateCustomer(int customerId,String updateCustomer);

	
}
