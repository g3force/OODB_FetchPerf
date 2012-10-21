package edu.dhbw.oodb.dao;

import java.util.List;

import edu.dhbw.oodb.entity.Order;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

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
	public List<Order> getAllOrders() {
		return getJpaTemplate().find("SELECT o FROM Order o JOIN FETCH o.customer");
	}

}
