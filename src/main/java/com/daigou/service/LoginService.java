package com.daigou.service;

import com.daigou.service.dto.LoginForm;
import com.daigou.service.dto.LoginUser;

public interface LoginService {

	LoginUser login(LoginForm loginForm);

}
