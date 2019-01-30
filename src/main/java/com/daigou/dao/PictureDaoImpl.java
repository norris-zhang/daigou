package com.daigou.dao;

import org.springframework.stereotype.Repository;

import com.daigou.datamodel.dgou_picture;

@Repository
public class PictureDaoImpl extends BaseDao<dgou_picture> implements PictureDao {

	@Override
	protected Class<dgou_picture> getGenericClass() {
		return dgou_picture.class;
	}
}
