package com.daigou.dao;

import org.springframework.stereotype.Repository;

import com.daigou.datamodel.dgou_user;

@Repository
public class UserDaoImpl extends BaseDao<dgou_user> implements UserDao {

	@Override
	protected Class<dgou_user> getGenericClass() {
		return dgou_user.class;
	}
	
}
