package com.daigou.datamodel;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dgou_product")
public class Product extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="prod_id")
	@GeneratedValue(strategy=IDENTITY)
	private Long id;
	@Column(name="prod_name")
	private String name;
	@Column(name="prod_name_en")
	private String nameEn;
	@Column(name="prod_title")
	private String title;
	@Column(name="prod_chan_di")
	private String chanDi;
	@Column(name="prod_gui_ge")
	private String guiGe;
	@Column(name="prod_description")
	private String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChanDi() {
		return chanDi;
	}
	public void setChanDi(String chanDi) {
		this.chanDi = chanDi;
	}
	public String getGuiGe() {
		return guiGe;
	}
	public void setGuiGe(String guiGe) {
		this.guiGe = guiGe;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
