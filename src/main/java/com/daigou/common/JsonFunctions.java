package com.daigou.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonFunctions {
	public static String obj2Json(Object obj) {
		if (obj instanceof Collection || obj.getClass().isArray()) {
			return obj2JsonArray(obj);
		} else {
			JSONObject json = new JSONObject(obj);
			return json.toString(0);
		}
	}
	public static String obj2JsonArray(Object obj) {
		if (obj instanceof Collection) {
			return new JSONArray((Collection)obj).toString(0);
		} else if (obj.getClass().isArray()) {
			JSONArray jsonArr = new JSONArray();
			Object[] objs = (Object[])obj;
			for (Object o : objs) {
				jsonArr.put(new JSONObject(o));
			}
			return jsonArr.toString(0);
		} else {
			JSONArray jsonArr = new JSONArray();
			jsonArr.put(new JSONObject(obj));
			return jsonArr.toString(0);
		}
	}
	private static Object jsonObj2Pojo(JSONObject json, Class clazz) {
		try {
			Constructor defaultConstructor = clazz.getDeclaredConstructor();
			Method[] declaredMethods = clazz.getDeclaredMethods();
			Object newInstance = defaultConstructor.newInstance();
			Set<String> keySet = json.keySet();
			for (String name : keySet) {
				Object value = json.get(name);
				for (Method m : declaredMethods) {
					String methodName = m.getName();
					if (methodName.equals("set" + name.substring(0, 1).toUpperCase() + name.substring(1))) {
						Class<?>[] parameterTypes = m.getParameterTypes();
						if (value instanceof JSONObject) {
							jsonObj2Pojo((JSONObject)value, parameterTypes[0]);
						} else if (value instanceof JSONArray) {

						} else if (parameterTypes[0]==Long.class || parameterTypes[0]==long.class) {
							m.invoke(newInstance, Long.valueOf(value.toString()));
						} else if (parameterTypes[0] == Integer.class || parameterTypes[0] == int.class) {
							m.invoke(newInstance, Integer.valueOf(value.toString()));
						} else if (parameterTypes[0] == Instant.class) {
							Instant instant = Instant.parse(value.toString());
							m.invoke(newInstance, instant);
						} else {
							m.invoke(newInstance, value);
						}
						break;
					}
				}
			}
			return newInstance;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static List<Map<String, Object>> jsonArray2MapList(String json) {
		List<Map<String, Object>> list = new ArrayList<>();
		new JSONArray(json).forEach(e -> list.add(((JSONObject)e).toMap()));
		return list;
	}

	public static boolean isJSONArray(String source) {
		try {
			new JSONArray(source);
			return true;
		} catch (JSONException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		String json = "[{\"id\":1,\"count\":2},{\"id\":2,\"count\":1}]";
		System.out.println(isJSONArray(json));
		List<Map<String, Object>> jsonArray2MapList = jsonArray2MapList(json);
		System.out.println(jsonArray2MapList);
	}
}
