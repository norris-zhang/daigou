package com.daigou.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.daigou.dao.PictureDao;
import com.daigou.datamodel.dgou_picture;

@Component
@Transactional
public class PictureServiceImpl implements PictureService {
	private PictureDao dao;
	public PictureServiceImpl(PictureDao dao) {
		this.dao = dao;
	}
	@Override
	public void save(dgou_picture pict) {
		dao.save(pict);
	}
	@Override
	public dgou_picture getPicture(Long id) {
		return dao.get(id);
	}

}
