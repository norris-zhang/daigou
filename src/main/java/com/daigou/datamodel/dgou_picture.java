package com.daigou.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class dgou_picture extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pict_id;
	@ManyToOne
	@JoinColumn(name="pict_for_prod_id")
	private dgou_product forProd;
	@Column
	private String pict_is_primary = "N";
	@Column
	private String pict_original_file_name;
	@Column
	private String pict_file_extension;
	@Column
	private Integer pict_width;
	@Column
	private Integer pict_height;
	@Column
	private Long pict_size;
	public Long getPict_id() {
		return pict_id;
	}
	public void setPict_id(Long pict_id) {
		this.pict_id = pict_id;
	}
	public dgou_product getForProd() {
		return forProd;
	}
	public void setForProd(dgou_product forProd) {
		this.forProd = forProd;
	}
	public String getPict_is_primary() {
		return pict_is_primary;
	}
	public void setPict_is_primary(String pict_is_primary) {
		this.pict_is_primary = pict_is_primary;
	}
	public String getPict_original_file_name() {
		return pict_original_file_name;
	}
	public void setPict_original_file_name(String pict_original_file_name) {
		this.pict_original_file_name = pict_original_file_name;
	}
	public String getPict_file_extension() {
		return pict_file_extension;
	}
	public void setPict_file_extension(String pict_file_extension) {
		this.pict_file_extension = pict_file_extension;
	}
	public Integer getPict_width() {
		return pict_width;
	}
	public void setPict_width(Integer pict_width) {
		this.pict_width = pict_width;
	}
	public Integer getPict_height() {
		return pict_height;
	}
	public void setPict_height(Integer pict_height) {
		this.pict_height = pict_height;
	}
	public Long getPict_size() {
		return pict_size;
	}
	public void setPict_size(Long pict_size) {
		this.pict_size = pict_size;
	}
}
