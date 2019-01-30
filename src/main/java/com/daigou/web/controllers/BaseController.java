package com.daigou.web.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.daigou.common.JsonFunctions;

public class BaseController {
	protected ModelAndView contextRedirect(String url, Model model) {
		return new ModelAndView(new RedirectView(url, true), model.asMap());
	}
	protected ModelAndView stringModelAndView(String content) {
		View v = new View() {
			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				response.getWriter().print(content);
			}

			@Override
			public String getContentType() {
				return "text/plain";
			}
		};
		return new ModelAndView(v);
	}
	protected ModelAndView jsonModelAndView(Object obj) {
		View v = new View() {
			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				response.getWriter().print(JsonFunctions.obj2Json(obj));
			}

			@Override
			public String getContentType() {
				return "text/json";
			}
		};
		return new ModelAndView(v);
	}
	protected ModelAndView pictureModelAndView(byte[] data, String extension) {
		View v = new View() {
			public void render(java.util.Map<String,?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				response.getOutputStream().write(data);
			};
			@Override
			public String getContentType() {
				if ("jpg".equalsIgnoreCase(extension)
						|| "jpeg".equalsIgnoreCase(extension)) {
					return "image/jpeg";
				}
				if ("gif".equalsIgnoreCase(extension)) {
					return "image/gif";
				}
				if ("png".equalsIgnoreCase(extension)) {
					return "image/png";
				}
				return View.super.getContentType();
			}
		};
		return new ModelAndView(v);
	}
}
