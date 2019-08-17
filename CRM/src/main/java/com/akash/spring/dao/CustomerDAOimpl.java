package com.akash.spring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.akash.spring.entity.Customer;


@Repository
public class CustomerDAOimpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Customer> getCustomer() {
		//get current hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		//create a query
		//execute query and get result list
		
		
		//return the result
		return (List<Customer>)session.createQuery(" from com.akash.spring.entity.Customer ").getResultList();
	}

	
	public void saveCustomer(Customer theCustomer) {
		// get current  session
		Session session=sessionFactory.getCurrentSession();
		
		//save the customer
		session.save(theCustomer);
		
	}

}
