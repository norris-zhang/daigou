package com.daigou.common;

import org.springframework.util.DigestUtils;

public class CodeFunctions {
	public static String toMD5(String src) {
		return DigestUtils.md5DigestAsHex(src.getBytes());
	}
}
