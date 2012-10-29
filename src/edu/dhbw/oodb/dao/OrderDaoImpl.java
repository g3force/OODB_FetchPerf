package edu.dhbw.oodb.dao;

import java.util.List;

import edu.dhbw.oodb.entity.Order;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {
	
	public static final int NUM_ENTRIES_FILTER = 150000;
	private static final String FILTER = " where o.id < " + NUM_ENTRIES_FILTER;
//	private static final String FILTER = "";

	@Override
	protected Class<Order> getEntityClass() {
		return Order.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Order getOrder(Long id) {
		List<Order> orders = 
			getJpaTemplate().find
			("select distinct c from Order c where c.id="+id);
		if (orders.size()>0) {
			Order order = orders.get(0);
			return order;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrdersJoinFetch() {
		return getJpaTemplate().find("SELECT o FROM Order o JOIN FETCH o.customer" + FILTER);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrders() {
		return getJpaTemplate().find("SELECT o FROM Order o WHERE o.id < 1000"); // + FILTER);
	}

}
