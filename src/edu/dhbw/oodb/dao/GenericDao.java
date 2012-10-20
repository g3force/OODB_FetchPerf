package edu.dhbw.oodb.dao;

import java.util.List;

public interface GenericDao<T> {
	
	T insert(T object);
	T update(T object);
	T findById (Long id);
	List<T> findAll();
	
}
