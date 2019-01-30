package com.daigou.service;

import com.daigou.datamodel.dgou_picture;

public interface PictureService {

	void save(dgou_picture pict);

	dgou_picture getPicture(Long id);

}
