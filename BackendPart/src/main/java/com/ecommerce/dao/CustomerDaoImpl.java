package com.ecommerce.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Customer;

@Repository
@Transactional
public class CustomerDaoImpl  implements CustomerDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	   
	   public void registerCustomer(Customer customer) {
		   Session session=sessionFactory.getCurrentSession();
		   session.save(customer);
	   }
}
