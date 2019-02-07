package com.daigou.web.filters;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.daigou.service.LoginService;
import com.daigou.service.dto.LoginUser;

@Component("LoginFilter")
public class LoginFilter implements Filter {
	// TODO
	// if the login user information is not in session some day, but in db or cache instead,
	// loginService is used to request for that.
	private LoginService loginService; 
	public LoginFilter(LoginService loginService) {
		this.loginService = loginService;
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		// request.getRequestURL(); // http://localhost:8080/daigou/admin/product/add
		String requestURI = request.getRequestURI(); // /daigou/admin/product/add
		requestURI = requestURI.replaceFirst(request.getContextPath(), "");
		if (requestURI.startsWith("/admin")) {
			HttpSession session = request.getSession();
			LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
			if (loginUser == null || "N".equalsIgnoreCase(loginUser.getUser().getUser_is_admin())) {
				// no user login or the login user is not an administrator.
				String redPath = requestURI;
				String queryString = request.getQueryString();
				if (queryString != null) {
					redPath += "?" + queryString;
				}
				redPath = URLEncoder.encode(redPath, "UTF-8");
				response.sendRedirect(request.getContextPath() + "/user/login?redPath=" + redPath);
				return;
			}
		}
		chain.doFilter(request, response);
	}

}
