package com.daigou.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.daigou.dao.InviteCodeDao;
import com.daigou.datamodel.InviteCode;

@Component
@Transactional
public class BusinessAdminServiceImpl implements BusinessAdminService {
	private InviteCodeDao inviteCodeDao;
	public BusinessAdminServiceImpl (InviteCodeDao inviteCodeDao) {
		this.inviteCodeDao = inviteCodeDao;
	}
	@Override
	public void save(InviteCode inviteCode) {
		inviteCodeDao.save(inviteCode);
	}

}
