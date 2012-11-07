package edu.dhbw.oodb.dao;

import java.util.List;

import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

import edu.dhbw.oodb.entity.Order;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {
	
	public static final int NUM_ENTRIES = 750000;

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
		return getJpaTemplate().find("SELECT o FROM Order o JOIN FETCH o.customer");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrders() {
		return getJpaTemplate().find("SELECT o FROM Order o");
	}
	
	@SuppressWarnings("unchecked")
	@BatchFetch(BatchFetchType.EXISTS)
	public List<Order> getAllOrdersExists() {
		return getJpaTemplate().find("SELECT o FROM Order o");
	}
	
	@SuppressWarnings("unchecked")
	@BatchFetch(BatchFetchType.JOIN)
	public List<Order> getAllOrdersJoin() {
		return getJpaTemplate().find("SELECT o FROM Order o");
	}
}
