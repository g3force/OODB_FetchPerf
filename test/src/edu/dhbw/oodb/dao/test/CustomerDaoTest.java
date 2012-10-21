package edu.dhbw.oodb.dao.test;

import java.util.List;

import org.junit.Test;

import edu.dhbw.oodb.dao.CustomerDao;
import edu.dhbw.oodb.entity.Customer;

public class CustomerDaoTest extends AbstractDaoTests {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao CustomerDao) {
		this.customerDao = CustomerDao;
	}

	@Test
	public void testFindById() {
		Customer customer = customerDao.findById(1L);
		assertTrue(customer != null);
	}

	@Test
	public void testGetCustomer() {
		Customer customer = customerDao.getCustomer(new Long(1));
		assertTrue(customer != null);
	}

	@Test
	public void testFindAll() {
		List<Customer> customers = customerDao.findAll();
		assertTrue("Customer size is " + customers.size(),
				customers.size() == 150000);
	}

}
