package edu.dhbw.oodb.dao;

import java.util.List;

import edu.dhbw.oodb.entity.Customer;

public interface CustomerDao  extends GenericDao<Customer> {

	public Customer getCustomer(Long id);

	public List<Customer> getAllCustomers();

	public List<Customer> getAllCustomersAndOrdersDao();
	
	public List<Customer> getAllCustomersBatchFetchExists();
	
	public List<Customer> getAllCustomersBatchFetchJoin();
	
	public List<Customer> getAllCustomersJoinFetch();

}
