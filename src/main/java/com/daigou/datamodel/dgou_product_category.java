package com.daigou.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class dgou_product_category extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long prca_id;
	@Column
	private String prca_name;
	@Column
	private String prca_description;
	public Long getPrca_id() {
		return prca_id;
	}
	public void setPrca_id(Long prca_id) {
		this.prca_id = prca_id;
	}
	public String getPrca_name() {
		return prca_name;
	}
	public void setPrca_name(String prca_name) {
		this.prca_name = prca_name;
	}
	public String getPrca_description() {
		return prca_description;
	}
	public void setPrca_description(String prca_description) {
		this.prca_description = prca_description;
	}
	
}
