package com.daigou.dao;

import org.springframework.stereotype.Repository;

import com.daigou.datamodel.dgou_price;

@Repository
public class PriceDaoImpl extends BaseDao<dgou_price> implements PriceDao {

	@Override
	protected Class<dgou_price> getGenericClass() {
		return dgou_price.class;
	}
	
}
