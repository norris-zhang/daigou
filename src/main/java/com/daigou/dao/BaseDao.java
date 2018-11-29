package com.daigou.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.daigou.common.paging.Page;
import com.daigou.datamodel.BaseEntity;

@Repository
public abstract class BaseDao<T extends BaseEntity> implements IDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected abstract Class<T> getGenericClass();
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(T t) {
		getSession().save(t);
	}
	@Override
	public void delete(T t) {
		getSession().delete(t);
	}
	@Override
	public void delete(Serializable id) {
		Session session = getSession();
		Optional.ofNullable(session.get(getGenericClass(), id))
				.ifPresent(e -> session.delete(e));
	}
	@Override
	public void update(T e) {
		getSession().update(e);
	}
	@Override
	public void executeUpdate(String hql, Object... args) {
		@SuppressWarnings("rawtypes")
		Query updateQuery = getSession().createQuery(hql);
		String name = null;
		for (int i = 0; i < args.length; i++) {
			if (i % 2 == 0) {
				name = (String)args[i];
			} else {
				updateQuery.setParameter(name, args[i]);
			}
		}
		updateQuery.executeUpdate();
	}
	@Override
	public void executeNativeUpdate(String sql, Object... args) {
		@SuppressWarnings("rawtypes")
		NativeQuery nativeQuery = getSession().createNativeQuery(sql);
		String name = null;
		for (int i = 0; i < args.length; i++) {
			if (i % 2 == 0) {
				name = (String)args[i];
			} else {
				nativeQuery.setParameter(name, args[i]);
			}
		}
		nativeQuery.executeUpdate();
	}
	@Override
	public T get(Serializable id) {
		return getSession().get(getGenericClass(), id);
	}
	@Override
	public List<T> queryList(String hql, Object... args) {
		@SuppressWarnings("unchecked")
		TypedQuery<T> query = getSession().createQuery(hql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		return query.getResultList();
	}
	@Override
	public List<T> queryListNamedParameters(String hql, Object... args) {
		@SuppressWarnings("unchecked")
		TypedQuery<T> query = getSession().createQuery(hql);
		String name = null;
		for (int i = 0; i < args.length; i++) {
			if (i % 2 == 0) {
				name = (String)args[i];
			} else {
				query.setParameter(name, args[i]);
			}
		}
		return query.getResultList();
	}
	@Override
	public List<T> queryList(String hql, Page page, Object... args) {
		@SuppressWarnings("unchecked")
		TypedQuery<T> query = getSession().createQuery(hql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		query.setFirstResult(page.getStartRowNum());
		query.setMaxResults(page.getPageSize());
		return query.getResultList();
	}
	@Override
	public List<T> queryListNamedParameters(String hql, Page page, Object... args) {
		@SuppressWarnings("unchecked")
		TypedQuery<T> query = getSession().createQuery(hql);
		String name = null;
		for (int i = 0; i < args.length; i++) {
			if (i % 2 == 0) {
				name = (String)args[i];
			} else {
				query.setParameter(name, args[i]);
			}
		}
		query.setFirstResult(page.getStartRowNum());
		query.setMaxResults(page.getPageSize());
		return query.getResultList();
	}
	@Override
	public int queryCount(String hql, Object... args) {
		@SuppressWarnings({ "rawtypes" })
		TypedQuery query = getSession().createQuery(hql);
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
		Long count = (Long)query.getSingleResult();
		return count.intValue();
	}
	@Override
	public int queryCountNamedParameters(String hql, Object... args) {
		@SuppressWarnings({ "rawtypes" })
		TypedQuery query = getSession().createQuery(hql);
		String name = null;
		for (int i = 0; i < args.length; i++) {
			if (i % 2 == 0) {
				name = (String)args[i];
			} else {
				query.setParameter(name, args[i]);
			}
		}
		Long count = (Long)query.getSingleResult();
		return count.intValue();
	}
}
