package com.daigou.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.daigou.datamodel.Product;

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
	public static Object json2Obj(String json, Class clazz) {

		JSONObject jsonObj = new JSONObject(json);
		return jsonObj2Pojo(jsonObj, clazz);

	}
	
	public static void main(String[] args) {
		Product prod = new Product();
		prod.setId(1L);
		prod.setChanDi("abdafdf");
		prod.setDescription("dafdsfdsaf");
		prod.setGuiGe("dsafdsf");
		prod.setName("dasfdsf");
		String obj2Json = obj2Json(prod);
		System.out.println(obj2Json);
		Object json2Obj = json2Obj(obj2Json, Product.class);
		System.out.println(json2Obj);
		List<Product> prodList = new ArrayList<>();
		prodList.add(prod);
		obj2Json = obj2JsonArray(prodList);
		System.out.println(obj2Json);
		obj2Json = obj2JsonArray(prod);
		System.out.println(obj2Json);
		Product[] prods = new Product[1];
		prods[0] = prod;
		obj2Json = obj2JsonArray(prods);
		System.out.println(obj2Json);
		
		/////
		A a = new A();
		a.setAge(23);
		a.setName("hahaha");
		B b = new B();
		b.setAaa(a);
		b.setAbc(45);
		b.setDef("hehehehe");
		List<A> alist = new ArrayList<>();
		alist.add(a);
		b.setAlist(alist);
		b.setDate(Instant.now());
		obj2Json = obj2Json(b);
		System.out.println(obj2Json);
		json2Obj = json2Obj(obj2Json, B.class);
		System.out.println(json2Obj);
	}
	public static class A {
		private int age;
		private String name;
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	public static class B {
		private int abc;
		private String def;
		private Instant date;
		private A aaa;
		private List<A> alist;
		public int getAbc() {
			return abc;
		}
		public void setAbc(int abc) {
			this.abc = abc;
		}
		public String getDef() {
			return def;
		}
		public void setDef(String def) {
			this.def = def;
		}
		public A getAaa() {
			return aaa;
		}
		public void setAaa(A aaa) {
			this.aaa = aaa;
		}
		public List<A> getAlist() {
			return alist;
		}
		public void setAlist(List<A> alist) {
			this.alist = alist;
		}
		public Instant getDate() {
			return date;
		}
		public void setDate(Instant date) {
			this.date = date;
		}
		
	}
}
