package edu.dhbw.oodb.dao;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDaoImpl<T> extends JpaDaoSupport implements GenericDao<T> {

	@Override
	@Transactional
	public T insert(T object) {
		getJpaTemplate().persist(object);
		getJpaTemplate().flush();
		return object;
	}
	
	@Override
	@Transactional
	public T update (T object) {
		object = getJpaTemplate().merge(object);
		getJpaTemplate().flush();
		return object;
	}

	@Override
	public T findById(Long id) {
		return getJpaTemplate().find(getEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getJpaTemplate().find("select o from "+getEntityClass().getSimpleName()+ " o");
	}
	
	protected abstract Class<T> getEntityClass(); 
	
}
