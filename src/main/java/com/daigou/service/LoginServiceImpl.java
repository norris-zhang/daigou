package com.daigou.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.daigou.common.CodeFunctions;
import com.daigou.dao.UserDao;
import com.daigou.datamodel.dgou_user;
import com.daigou.service.dto.LoginForm;
import com.daigou.service.dto.LoginUser;

@Component
@Transactional
public class LoginServiceImpl implements LoginService {
	private UserDao userDao;
	public LoginServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public LoginUser login(LoginForm loginForm) {
		String hql = "from dgou_user where user_login_id=:loginid and user_login_password=:password";
		List<dgou_user> userList = userDao.queryListNamedParameters(hql,
				"loginid", loginForm.getLoginid(),
				"password", CodeFunctions.toMD5(loginForm.getPassword()));
		if (userList == null || userList.size() == 0 ) {
			return null;
		}
		LoginUser loginUser = new LoginUser();
		loginUser.setUser(userList.get(0));
		return loginUser;
	}

}
