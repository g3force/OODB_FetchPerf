package edu.dhbw.oodb.dao;

import java.util.List;

import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;
import org.springframework.beans.factory.annotation.Autowired;

import edu.dhbw.oodb.entity.Customer;
import edu.dhbw.oodb.entity.Order;

public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

	public static final int NUM_ENTRIES = 75000;
	
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
	public List<Customer> getAllCustomers() {
		return getJpaTemplate().find("select c from Customer c");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomersJoinFetch() {
		return getJpaTemplate().find("SELECT c FROM Customer c JOIN FETCH c.orders");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@BatchFetch(BatchFetchType.JOIN)
	public List<Customer> getAllCustomersBatchFetchJoin() {
		return getJpaTemplate().find("select c from Customer c");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@BatchFetch(BatchFetchType.EXISTS)
	public List<Customer> getAllCustomersBatchFetchExists() {
		return getJpaTemplate().find("select c from Customer c");
	}
	
	@Override
	public List<Customer> getAllCustomersAndOrdersDao() {
		List<Customer> cs = this.getAllCustomers();
		
		for(Customer c : cs) {
			List<Order> os = orderDao.getOrdersByCustkey( c.getCCustkey() );
			c.setOrders(os);
		}

		return cs;
	}

}
