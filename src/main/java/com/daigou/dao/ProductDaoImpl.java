package com.daigou.dao;

import org.springframework.stereotype.Repository;

import com.daigou.datamodel.dgou_product;

@Repository
public class ProductDaoImpl extends BaseDao<dgou_product> implements ProductDao {

	@Override
	protected Class<dgou_product> getGenericClass() {
		return dgou_product.class;
	}
	
}
