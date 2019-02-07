package com.daigou.service.dto;

public class LoginForm {
	private String loginid;
	private String password;
	private String redPath;
	private String rememberMe;
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRedPath() {
		return redPath;
	}
	public void setRedPath(String redPath) {
		this.redPath = redPath;
	}
	public String getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
}
