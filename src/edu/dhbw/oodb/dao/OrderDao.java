package edu.dhbw.oodb.dao;

import edu.dhbw.oodb.entity.Order;

public interface OrderDao  extends GenericDao<Order> {

	Order getOrder(Long id);
	
}
