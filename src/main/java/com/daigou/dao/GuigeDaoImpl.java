package com.daigou.dao;

import org.springframework.stereotype.Repository;

import com.daigou.datamodel.dgou_guige;

@Repository
public class GuigeDaoImpl extends BaseDao<dgou_guige> implements GuigeDao {

	@Override
	protected Class<dgou_guige> getGenericClass() {
		return dgou_guige.class;
	}
	
}
