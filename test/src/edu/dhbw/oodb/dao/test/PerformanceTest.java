package edu.dhbw.oodb.dao.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

import edu.dhbw.oodb.dao.CustomerDao;
import edu.dhbw.oodb.dao.CustomerDaoImpl;
import edu.dhbw.oodb.dao.OrderDao;
import edu.dhbw.oodb.dao.OrderDaoImpl;
import edu.dhbw.oodb.entity.Customer;
import edu.dhbw.oodb.entity.Order;
import edu.dhbw.oodb.jpql.ManualFetch;

/**
 * -XX:PermSize=64M -XX:MaxPermSize=265m
 */
@BenchmarkMethodChart(filePrefix = "performance")
@BenchmarkHistoryChart(filePrefix = "performance-history")
@BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 1)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PerformanceTest extends AbstractDaoTests {
	/**
	 * To modify the Benchmark runs use at the test method or globally in
	 * AbstractDaoTests:
	 * 
	 * @BenchmarkOptions(benchmarkRounds = 2, warmupRounds = 0)
	 */

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private OrderDao orderDao;

	public void setCustomerDao(CustomerDao CustomerDao) {
		this.customerDao = CustomerDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/**
	 * Check if orders includes correct amount of rows
	 * and if customers are also available
	 * 
	 * @param orders
	 */
	private void checkOrders(List<Order> orders) {
		assertTrue("" + orders.size(),
				orders.size() == OrderDaoImpl.NUM_ENTRIES);
		for (int i = 0; i < orders.size(); i++) {
			assertTrue("order " + i + " is null", orders.get(i) != null);
			assertTrue("customer of order " + i + " is null", orders.get(i)
					.getOCustkey() != null);
		}
	}
	
	private void checkCustomers(List<Customer> customers) {
		for(Customer customer : customers) {
			for (int i = 0; i < customer.getOrders().size(); i++) {
				assertTrue("order " + i + " is null", customer.getOrders().get(i) != null);
			}
		}
	}
	
	
	// ################################################################################
	// ################################### customers ##################################
	// ################################################################################

	@Test
	public void getAllCustomers() {
		List<Customer> customers = this.customerDao.getAllCustomer();
		assertTrue("" + customers.size(),
				customers.size() == CustomerDaoImpl.NUM_ENTRIES);
		assertTrue("First customer is null", customers.get(0) != null);
		checkCustomers(customers);
		customerDao.clearCache();
	}

	@Test
	public void getAllCustomersBatchFetchExists() {
		List<Customer> customers = this.customerDao.getAllCustomerBatchFetchExists();
		assertTrue("" + customers.size(),
				customers.size() == CustomerDaoImpl.NUM_ENTRIES);
		assertTrue("First customer is null", customers.get(0) != null);
		checkCustomers(customers);
		customerDao.clearCache();
	}

	@Test
	public void getAllCustomersBatchFetchJoin() {
		List<Customer> customers = this.customerDao.getAllCustomerBatchFetchJoin();
		assertTrue("" + customers.size(),
				customers.size() == CustomerDaoImpl.NUM_ENTRIES);
		assertTrue("First customer is null", customers.get(0) != null);
		checkCustomers(customers);
		customerDao.clearCache();
	}
	
	// ################################################################################
	// ################################### orders #####################################
	// ################################################################################


	@Test
	public void getAllOrdersJoinFetch() {
		List<Order> orders = this.orderDao.getAllOrdersJoinFetch();
		checkOrders(orders);
		orderDao.clearCache();
	}
	
	
	@Test
	public void getAllOrders() {
		List<Order> orders = this.orderDao.getAllOrders();
		checkOrders(orders);
		orderDao.clearCache();
	}

//	/**
//	 * Use BatchFetchType.EXIST
//	 */
//	@Test
//	public void getAllOrdersBatchExists() {
//		List<Order> orders = this.orderDao.getAllOrdersExists();
//		checkOrders(orders);
//	}
//
//	/**
//	 * Use BatchFetchType.JOIN
//	 */
//	@Test
//	public void getAllOrdersBatchJoin() {
//		List<Order> orders = this.orderDao.getAllOrdersJoin();
//		checkOrders(orders);
//	}

	/**
	 * get all customers first and load for each customer all orders
	 */
	@Test
	public void getAllCustomerAndOrdersDao() {
		List<Customer> customers = this.customerDao
				.getAllCustomerAndOrdersDao();
		assertTrue("Customer size is " + customers.size(),
				customers.size() == CustomerDaoImpl.NUM_ENTRIES);
		customerDao.clearCache();
	}

	/**
	 * get all customers first and load for each customer all orders use entity
	 * manager directly
	 */
	@Test
	public void getAllCustomerAndOrdersEM() {
		List<Customer> cs = ManualFetch.getAllCustomerAndOrders();
		assertTrue("" + cs.size(), cs.size() == CustomerDaoImpl.NUM_ENTRIES);
		assertTrue("First customer is null", cs.get(0) != null);
		assertTrue("Order is null", cs.get(0).getOrders() != null);
	}
	
	
	
	
	
	
	
	

	// @Test
	// public void testFindAll() {
	// List<Customer> customers = this.customerDao.findAll();
	// assertTrue("Customer size is " + customers.size(),
	// customers.size() == CustomerDaoImpl.NUM_ENTRIES);
	// }

	// /**
	// * Same as getAllOrders
	// */
	// @Test
	// public void findAll() {
	// List<Order> orders = orderDao.findAll();
	// assertTrue("" + orders.size(),
	// orders.size() == OrderDaoImpl.NUM_ENTRIES);
	// assertTrue("First order is null", orders.get(0) != null);
	// assertTrue("Customer is not null", orders.get(0).getOCustkey() != null);
	// }

	// @Test
	// public void testFindById() {
	// Order order = this.orderDao.findById(1L);
	// assertTrue(order != null);
	// }

	// @Test
	// public void testGetOrder() {
	// Order order = this.orderDao.getOrder(new Long(1));
	// assertTrue(order != null);
	// }
}