package com.daigou.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class dgou_user extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long user_id;
	@Column
	private String user_login_id;
	@Column
	private String user_login_password;
	@Column
	private String user_is_admin;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_login_id() {
		return user_login_id;
	}
	public void setUser_login_id(String user_login_id) {
		this.user_login_id = user_login_id;
	}
	public String getUser_login_password() {
		return user_login_password;
	}
	public void setUser_login_password(String user_login_password) {
		this.user_login_password = user_login_password;
	}
	public String getUser_is_admin() {
		return user_is_admin;
	}
	public void setUser_is_admin(String user_is_admin) {
		this.user_is_admin = user_is_admin;
	}
}
