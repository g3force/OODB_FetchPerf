package edu.dhbw.oodb.dao;

import java.util.List;

import edu.dhbw.oodb.entity.Order;

public interface OrderDao  extends GenericDao<Order> {

	Order getOrder(Long id);
	
	public List<Order> getAllOrdersJoinFetch();
	
	public List<Order> getAllOrders();
	
	public List<Order> getAllOrdersExists();
	
	public List<Order> getAllOrdersJoin();

	public List<Order> getOrdersByCustkey(Long id);
}
