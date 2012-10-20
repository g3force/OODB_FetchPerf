package edu.dhbw.oodb.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.dhbw.oodb.dao.CustomerDao;
import edu.dhbw.oodb.dao.OrderDao;
import edu.dhbw.oodb.entity.Customer;

public class CustomerDaoImplTest extends AbstractDaoTests {

	private CustomerDao customerDao;
	private OrderDao orderDao;
	
	private static ApplicationContext appContext;
	private static Connection jdbcConnection;
	
	public void setOrderDao(OrderDao OrderDao) {
		this.orderDao = OrderDao;
	}

	public void setCustomerDao(CustomerDao CustomerDao) {
		this.customerDao = CustomerDao;
	}

	public void testFindById() {
		Customer student = customerDao.findById(24002L);
	}

	public void testFindAll() {
		List<Customer> students = customerDao.findAll();
		assertTrue(students.size()==8);
	}
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	      try {
	    	  //Class.forName("com.mysql.jdbc.Driver");
	    	  appContext = new ClassPathXmlApplicationContext( "db.xml" );
//		      customerDao = (CustomerDao) appContext.getBean("customerDao");
//		      orderDao = (OrderDao) appContext.getBean("orderDao");
		      jdbcConnection = DriverManager.getConnection(
					  "jdbc:oracle:thin:@localhost:1521:XE", "tpch", "tpch");
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		  jdbcConnection.setAutoCommit(false);
//	      IDatabaseConnection connection = new DatabaseConnection(jdbcConnection,"UNI");
//	      IDataSet dataSet = new FlatXmlDataSet(new File("uni.xml"));
//	      DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
//	      jdbcConnection.commit();
//	      jdbcConnection.close();
	}

	@Test
	public void testGetCustomer() {
		Customer customer = customerDao.getCustomer(new Long(0));
		assertTrue(customer != null);
		System.out.println(customer);
	}

}
