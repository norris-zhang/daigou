package com.daigou.service.dto;

import java.io.Serializable;

import com.daigou.datamodel.dgou_user;

public class LoginUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private dgou_user user;
	public dgou_user getUser() {
		return user;
	}
	public void setUser(dgou_user user) {
		this.user = user;
	}
}
