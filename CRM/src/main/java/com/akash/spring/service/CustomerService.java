package com.akash.spring.service;

import java.util.List;

import com.akash.spring.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);

}
