package com.akash.spring.dao;

import java.util.List;

import com.akash.spring.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);
}
