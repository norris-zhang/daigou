package com.daigou.dao;

import org.springframework.stereotype.Repository;

import com.daigou.datamodel.InviteCode;

@Repository
public class InviteCodeDaoImpl extends BaseDao<InviteCode> implements InviteCodeDao {
	@Override
	protected Class<InviteCode> getGenericClass() {
		return InviteCode.class;
	}

}
