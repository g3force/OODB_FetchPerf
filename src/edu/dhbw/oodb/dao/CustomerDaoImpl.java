package edu.dhbw.oodb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.dhbw.oodb.entity.Customer;
import edu.dhbw.oodb.entity.Order;

public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

	public static final int NUM_ENTRIES = 86224;//75000;	//86224
	
	@Autowired
	private OrderDao orderDao;
	
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomer() {
		return getJpaTemplate().find("select c from Customer c");
	}
	
	@Override
	public List<Customer> getAllCustomerAndOrdersDao() {
		List<Customer> cs = this.getAllCustomer();
		
		for(Customer c : cs) {
			List<Order> os = orderDao.getOrdersByCustkey( c.getCCustkey() );
			c.setOrders(os);
		}

		return cs;
	}

}
