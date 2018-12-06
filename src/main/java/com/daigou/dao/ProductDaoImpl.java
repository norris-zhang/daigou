package com.daigou.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.daigou.common.paging.Page;
import com.daigou.datamodel.Product;

@Repository
public class ProductDaoImpl extends BaseDao<Product> implements ProductDao {

	@Override
	protected Class<Product> getGenericClass() {
		return Product.class;
	}

	@Override
	public void save(Product e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Product e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Product e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeUpdate(String hql, Object... args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeNativeUpdate(String sql, Object... args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> queryList(String hql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> queryListNamedParameters(String hql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> queryList(String hql, Page page, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> queryListNamedParameters(String hql, Page page, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryCount(String hql, Object... args) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryCountNamedParameters(String hql, Object... args) {
		// TODO Auto-generated method stub
		return 0;
	}

}
