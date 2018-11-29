package com.daigou.datamodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="dgou_invite_code")
public class InviteCode extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ivcd_id")
	@GeneratedValue(strategy=IDENTITY)
	private Long id;
	@Column(name="ivcd_code")
	private String code;
	@Column(name="ivcd_name")
	private String name;
	@Column(name="ivcd_wx_name")
	private String wxName;
	@Column(name="ivcd_wx_id")
	private String wxId;
	@Column(name="ivcd_last_updated")
	private Date lastUpdated;
	@Column(name="ivcd_last_updated_by")
	private String lastUpdatedBy;
	@Version
	@Column(name="ivcd_stamp")
	private int stamp;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWxName() {
		return wxName;
	}
	public void setWxName(String wxName) {
		this.wxName = wxName;
	}
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public int getStamp() {
		return stamp;
	}
	public void setStamp(int stamp) {
		this.stamp = stamp;
	}

}
