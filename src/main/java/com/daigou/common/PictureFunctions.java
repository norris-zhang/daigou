package com.daigou.common;

public class PictureFunctions {
	public static String getPath(Long id, String extension) {
		return "pictures/" + (id/1000) + "/" + id + "." + extension;
	}
}
