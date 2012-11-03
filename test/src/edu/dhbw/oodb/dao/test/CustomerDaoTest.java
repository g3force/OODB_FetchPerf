package edu.dhbw.oodb.dao.test;

import java.util.List;

import org.junit.Test;
import org.perfidix.annotation.Bench;
import org.perfidix.annotation.BenchClass;

import edu.dhbw.oodb.dao.CustomerDao;
import edu.dhbw.oodb.dao.CustomerDaoImpl;
import edu.dhbw.oodb.entity.Customer;


@BenchClass(runs = 100)
public class CustomerDaoTest extends AbstractDaoTests {
	
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao CustomerDao) {
		this.customerDao = CustomerDao;
	}
	
	@Test
	@Bench
	public void testFindById() {
		Customer customer = this.customerDao.findById(1L);
		assertTrue(customer != null);
	}
	
	@Test
	@Bench
	public void testGetCustomer() {
		Customer customer = this.customerDao.getCustomer(new Long(1));
		assertTrue(customer != null);
	}
	
	@Test
	@Bench
	public void testFindAll() {
		List<Customer> customers = this.customerDao.findAll();
		assertTrue("Customer size is " + customers.size(),
				customers.size() == CustomerDaoImpl.NUM_ENTRIES);
	}
	
}
