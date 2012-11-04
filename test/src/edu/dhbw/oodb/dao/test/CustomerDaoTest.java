package edu.dhbw.oodb.dao.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

import edu.dhbw.oodb.dao.CustomerDao;
import edu.dhbw.oodb.dao.CustomerDaoImpl;
import edu.dhbw.oodb.entity.Customer;

@BenchmarkMethodChart(filePrefix = "customerDao-lists")
@BenchmarkHistoryChart(filePrefix = "customerDao-history")
public class CustomerDaoTest extends AbstractDaoTests {
	/**
	 * To modify the Benchmark runs use at the test method or globally in AbstractDaoTests: 
	 * @BenchmarkOptions(benchmarkRounds = 2, warmupRounds = 0)
	 */
	@Autowired
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao CustomerDao) {
		this.customerDao = CustomerDao;
	}

	@Test
	public void testFindById() {
		Customer customer = this.customerDao.findById(1L);
		assertTrue(customer != null);
	}

	@Test
	public void testGetCustomer() {
		Customer customer = this.customerDao.getCustomer(new Long(1));
		assertTrue(customer != null);
	}

	@Test
	public void testFindAll() {
		List<Customer> customers = this.customerDao.findAll();
		assertTrue("Customer size is " + customers.size(),
				customers.size() == CustomerDaoImpl.NUM_ENTRIES);
	}

}
