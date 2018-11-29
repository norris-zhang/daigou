package com.daigou.dao;

import java.io.Serializable;
import java.util.List;

import com.daigou.common.paging.Page;
import com.daigou.datamodel.BaseEntity;

public interface IDao<T extends BaseEntity> {
	void save(T e);
	void delete(T e);
	void delete(Serializable id);
	void update(T e);
	void executeUpdate(String hql, Object... args);
	void executeNativeUpdate(String sql, Object... args);
	T get(Serializable id);
	List<T> queryList(String hql, Object... args);
	List<T> queryListNamedParameters(String hql, Object... args);
	List<T> queryList(String hql, Page page, Object... args);
	List<T> queryListNamedParameters(String hql, Page page, Object... args);
	int queryCount(String hql, Object... args);
	int queryCountNamedParameters(String hql, Object... args);
}
