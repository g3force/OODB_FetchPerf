package edu.dhbw.oodb.jpql;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.dhbw.oodb.entity.Customer;
import edu.dhbw.oodb.entity.Order;

public class ManualFetch {
	
//	public static void main(String[] args) {
//		List<Customer> cs = getAllCustomerAndOrders();
//		System.out.println( cs.size() );
//	}
	
	public static List<Customer> getAllCustomerAndOrders() {
		List<Customer> cs = getAllCustomer();
		
		for( Customer c : cs ) {
			List<Order> os = getOrderByCustomer(c);
//			System.out.println("ID: "+c.getCCustkey() + "\tORDERS: "+os.size());
			c.setOrders(os);
		}
		
		return cs;
	}
	
	public static List<Order> getAllOrders() {
		EntityManager em = EMFactory.getEntityManager();
		List<Order> results = em.createQuery("SELECT o FROM Order o").getResultList();
		em.close();
		
		return results;
	}
	
	public static List<Order> getOrderByCustomer(Customer c) {
		EntityManager em = EMFactory.getEntityManager();
		List<Order> results = em.createQuery("SELECT o FROM Order o WHERE o.customer.id="+c.getCCustkey()).getResultList();
		em.close();
		
		return results;
	}
	
	public static Order getOrderById(Long id) {
		EntityManager em = EMFactory.getEntityManager();
		
		List<Order> results = em.createQuery("SELECT o FROM Order o WHERE o.id="+id).getResultList();
		Order result = results.get(0);
		
		em.close();
		
		return result;
	}
	
	public static List<Customer> getAllCustomer() {
		EntityManager em = EMFactory.getEntityManager();
		List<Customer> results = em.createQuery("SELECT c FROM Customer c").getResultList();
		em.close();
		
		return results;
	}
	
	public static HashMap<Long, Customer> getAllCustomerAsHash() {
		
		return null;
	}
	
	public static Customer getCustomerById(Long id) {
		EntityManager em = EMFactory.getEntityManager();
		
		List<Customer> results = em.createQuery("SELECT c FROM Customer c WHERE c.id="+id).getResultList();
		Customer result = results.get(0);
		
		em.close();
		
		return result;
	}

}
