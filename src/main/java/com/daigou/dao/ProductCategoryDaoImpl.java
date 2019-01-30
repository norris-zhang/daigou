package com.daigou.dao;

import org.springframework.stereotype.Repository;

import com.daigou.datamodel.dgou_product_category;

@Repository
public class ProductCategoryDaoImpl extends BaseDao<dgou_product_category> implements ProductCategoryDao {

	@Override
	protected Class<dgou_product_category> getGenericClass() {
		return dgou_product_category.class;
	}
	
}
