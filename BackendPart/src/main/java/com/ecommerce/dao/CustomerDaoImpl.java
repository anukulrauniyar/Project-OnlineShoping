package com.ecommerce.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomerDaoImpl  implements CustomerDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	   
	   public void registerCustomer(Customer customer) {
		   Session session=sessionFactory.getCurrentSession();
		   session.save(customer)
	   }
}
