package edu.dhbw.oodb.dao.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;

import edu.dhbw.oodb.dao.CustomerDaoImpl;
import edu.dhbw.oodb.dao.OrderDao;
import edu.dhbw.oodb.dao.OrderDaoImpl;
import edu.dhbw.oodb.entity.Customer;
import edu.dhbw.oodb.entity.Order;

import edu.dhbw.oodb.jpql.ManualFetch;

/**
 * -XX:PermSize=64M -XX:MaxPermSize=265m
 * 
 * @author ubuntuuser
 * 
 */
@BenchmarkMethodChart(filePrefix = "orders")
@BenchmarkHistoryChart(filePrefix = "orders-history")
public class OrderDaoTest extends AbstractDaoTests {

	/**
	 * To modify the Benchmark runs use at the test method or globally in
	 * AbstractDaoTests:
	 * 
	 * @BenchmarkOptions(benchmarkRounds = 2, warmupRounds = 0)
	 */

	@Autowired
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Test
	public void getAllOrdersJoinFetch() {
		List<Order> orders = this.orderDao.getAllOrdersJoinFetch();
		assertTrue("" + orders.size() + "; " + OrderDaoImpl.NUM_ENTRIES,
				orders.size() == OrderDaoImpl.NUM_ENTRIES);
		assertTrue("First order is null", orders.get(0) != null);
		assertTrue("Customer is null", orders.get(0).getOCustkey() != null);
	}

	@Test
	public void getAllOrders() {
		List<Order> orders = this.orderDao.getAllOrders();
		assertTrue("" + orders.size(),
				orders.size() == OrderDaoImpl.NUM_ENTRIES);
		assertTrue("First order is null", orders.get(0) != null);
		assertTrue("Customer is not null", orders.get(0).getOCustkey() != null);
	}

	/**
	 * Use BatchFetchType.EXIST
	 */
	@Test
	public void getAllOrdersExists() {
		List<Order> orders = this.orderDao.getAllOrdersExists();
		assertTrue("" + orders.size(),
				orders.size() == OrderDaoImpl.NUM_ENTRIES);
		assertTrue("First order is null", orders.get(0) != null);
		assertTrue("Customer is null", orders.get(0).getOCustkey() != null);
	}

	/**
	 * Use BatchFetchType.JOIN
	 */
	@Test
	public void getAllOrdersJoin() {
		List<Order> orders = this.orderDao.getAllOrdersJoin();
		assertTrue("" + orders.size(),
				orders.size() == OrderDaoImpl.NUM_ENTRIES);
		assertTrue("First order is null", orders.get(0) != null);
		assertTrue("Customer is null", orders.get(0).getOCustkey() != null);
	}

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
