package com.daigou.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daigou.datamodel.InviteCode;
import com.daigou.service.BusinessAdminService;

@Controller
@RequestMapping(value="/admin")
public class BusinessAdminController extends BaseController {
	private BusinessAdminService businessAdminService;
	public BusinessAdminController(BusinessAdminService businessAdminService) {
		this.businessAdminService = businessAdminService;
	}

	@RequestMapping(value="/saveinvitecode", method=RequestMethod.GET)
	public ModelAndView saveBaseInfo(Model model) throws Exception {
		InviteCode inviteCode = new InviteCode();
		businessAdminService.save(inviteCode);
		return new ModelAndView("/index.jsp", model.asMap());
	}
}
