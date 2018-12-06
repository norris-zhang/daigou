package com.daigou.dao;

import org.springframework.stereotype.Repository;

import com.daigou.datamodel.BestSelling;

@Repository
public class BestSellingDaoImpl extends BaseDao<BestSelling> implements BestSellingDao {

	@Override
	protected Class<BestSelling> getGenericClass() {
		return BestSelling.class;
	}

}
