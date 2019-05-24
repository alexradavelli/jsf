package br.com.alexradavelli.javaeejsf.repository.impl;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.alexradavelli.javaeejsf.repository.JPARepository;

public abstract class JPARepositoryImpl<T, PK> implements JPARepository<T, PK> {
	
	@PersistenceContext(unitName = "javaee-jsf")
	protected EntityManager entityManager;

	@Override
	public Optional<T> findById(PK id) {
		return Optional.ofNullable(entityManager.find(getClassType(), id));
	}

	@Override
	public Collection<T> findAll() {
		return entityManager.createQuery("FROM " + getClassType().getName(), getClassType()).getResultList();
	}

	@Override
	public Query createQuery(String queryString, Object... parameters) {
		Query query = entityManager.createQuery(queryString);
		 
        for (int i = 1; i <= parameters.length; i++) {
            query.setParameter(i, parameters[i]);
        }
        return query;
	}

	@Override
	public T insert(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	@Override
	public T update(T entity) {
		entity = entityManager.merge(entity);
		entityManager.flush();
		return entity;
	}

	@Override
	public void remove(T entity) {
		entityManager.remove(entity);
	}
	
	protected abstract Class<T> getClassType();
	
}
