package com.daigou.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daigou.service.LoginService;
import com.daigou.service.dto.LoginForm;
import com.daigou.service.dto.LoginUser;

@Controller
public class UserController extends BaseController {
	private LoginService loginService;
	public UserController(LoginService loginService) {
		this.loginService = loginService;
	}
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public ModelAndView getLogin(@RequestParam(required=false) String redPath, Model model) {
		model.addAttribute("redPath", redPath);
		return new ModelAndView("/user/login.jsp", model.asMap());
	}

	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public ModelAndView postLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm, 
		      BindingResult result, RedirectAttributes redirAttrs, HttpServletRequest request) {
		LoginUser loginUser = loginService.login(loginForm);
		if (loginUser == null) {
			return contextRedirect("/user/login?redPath=" + loginForm.getRedPath(), redirAttrs);
		}
		request.getSession().setAttribute("loginUser", loginUser);

		String redPath = loginForm.getRedPath();
		if (redPath == null || redPath.trim().length() == 0) {
			redPath = "/";
		}
		return new ModelAndView("redirect:" + redPath, redirAttrs.asMap());
	}
}
