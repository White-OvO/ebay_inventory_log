package com.promineotech.service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.entity.Customer;
import com.promineotech.dao.CustomerDao;
//import com.promineotech.jeep.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultCustomerService implements CustomerService {
  @Autowired
  private CustomerDao customerDao;
  
  @Override
  
  public List<Customer> fetchAllCustomers() { 
		List<Customer> customer = customerDao.fetchAllCustomer();
		if(customer.isEmpty()) {
			String msg = String.format("There are no customers :(");
			throw new NoSuchElementException(msg);
		}
		return customer;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////// string and int check 
public Customer createCustomer(String EbayUsername ) {
	log.info("Creates customers in Service");
	return customerDao.createCustomer(EbayUsername);
	
}
@Override
public Customer updateCustomer(int customerId, String updatedCustomer) { 
	log.info("update customer in the service ");
	return customerDao.updateCustomer(customerId, updatedCustomer);
}
@Override
////////////////////////// CRUD DELETES 
public void deleteCustomer(int customerId) { 
	log.info("delete method was cast upon your request", customerId);
	
	customerDao.deleteCustomer(customerId);
}










}