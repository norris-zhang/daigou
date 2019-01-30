package com.daigou.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daigou.common.PictureFunctions;
import com.daigou.datamodel.dgou_picture;
import com.daigou.service.PictureService;

@Controller
public class PictureController extends BaseController {
	private PictureService pictureService;
	public PictureController(PictureService pictureService) {
		this.pictureService = pictureService;
	}
	@RequestMapping(value="/picture/{id}", method=GET)
	public ModelAndView viewProduct(@PathVariable Long id, Model model) {
		dgou_picture pict = pictureService.getPicture(id);
		byte[] data = PictureFunctions.getPictureData(pict.getPict_id(), pict.getPict_file_extension());
		return pictureModelAndView(data, pict.getPict_file_extension());
	}
}
