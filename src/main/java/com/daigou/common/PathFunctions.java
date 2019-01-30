package com.daigou.common;

import java.io.File;

public class PathFunctions {
	public static String getWebContentRoot() {
		String path = PathFunctions.class.getResource("/").getPath();
		File file = new File(path);
		while (!file.getName().equals("WEB-INF")) {
			file = file.getParentFile();
			if (file == null) {
				throw new RuntimeException("Cannot find WEB-INF");
			}
		}
		return file.getParentFile().getAbsolutePath();
	}
}
