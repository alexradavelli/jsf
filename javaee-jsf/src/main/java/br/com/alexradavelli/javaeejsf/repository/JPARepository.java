package br.com.alexradavelli.javaeejsf.repository;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.Query;

public interface JPARepository<T, PK> {
	
	Optional<T> findById(PK id);
	
	Collection<T> findAll();
	
	Query createQuery(String queryString, Object... parameters);
	
	T insert(T entity);
	
	T update(T entity);
	
	void remove(T entity);

}
