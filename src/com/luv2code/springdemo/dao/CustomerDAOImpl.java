package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	
	public List<Customer> getCustomers() {

		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query....sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and result list
		List<Customer> customers = theQuery.getResultList();

		// return the result
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the customer
		currentSession.saveOrUpdate(theCustomer);
		
		
		
	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class,theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		
		//get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId",theId);
		
		theQuery.executeUpdate();
		
	}
	
	public Customer loginCustomer(String firstName,String lastName,String email) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("select from Customer where first_name=firstName,last_name=lastName,email=email");
		theQuery.setParameter("firstName", firstName);
		theQuery.setParameter("lastName", lastName);
		theQuery.setParameter("email", email);
		theQuery.executeUpdate();
	
		
		
		return null;
		
	}
}
