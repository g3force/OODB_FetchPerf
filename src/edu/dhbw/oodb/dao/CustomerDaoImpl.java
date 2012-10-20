package edu.dhbw.oodb.dao;

import java.util.List;

import edu.dhbw.oodb.entity.Customer;

public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

	@Override
	protected Class<Customer> getEntityClass() {
		return Customer.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Customer getCustomer(Long id) {
		List<Customer> customers = 
			getJpaTemplate().find
			("select distinct c from Customer c where c.id="+id);
		if (customers.size()>0) {
			Customer customer = customers.get(0);
			return customer;
		} else {
			return null;
		}
	}

}
