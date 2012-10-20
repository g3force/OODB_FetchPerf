package edu.dhbw.oodb.dao;

import edu.dhbw.oodb.entity.Customer;

public interface CustomerDao  extends GenericDao<Customer> {

	Customer getCustomer(Long id);
	
}
