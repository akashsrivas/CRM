package com.akash.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akash.spring.dao.CustomerDAO;
import com.akash.spring.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;
	
	@Transactional
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customerDao.getCustomer();
	}

	@Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDao.saveCustomer(theCustomer);
		
	}
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(id);
	}
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(id);
	}

}
