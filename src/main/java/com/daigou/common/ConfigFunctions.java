package com.daigou.common;

import java.io.IOException;
import java.util.Properties;

public class ConfigFunctions {
	private static final ConfigFunctions instance = new ConfigFunctions();
	private Properties prop = new Properties();
	private Exception ex = null;
	private ConfigFunctions(){
		try {
			prop.load(ConfigFunctions.class.getResourceAsStream("/config/project.properties"));
		} catch (IOException e) {
			ex = e;
		}
	}
	private static ConfigFunctions getInstance() {
		if (instance.ex != null) {
			throw new RuntimeException(instance.ex);
		}
		return instance;
	}
	public static String getProperty(String key) {
		return getProperty(key, null);
	}
	private static String getProperty(String key, String defaultValue) {
		return getInstance().prop.getProperty(key, defaultValue);
	}
}
