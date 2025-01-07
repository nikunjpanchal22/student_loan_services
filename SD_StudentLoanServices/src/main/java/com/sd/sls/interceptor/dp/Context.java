package com.sd.sls.interceptor.dp;
/*
 * @Author: Abhishek Vishwakarma
*/
import java.util.HashMap;
import java.util.Map;

public class Context {
	private Map<String, Object> data = new HashMap<>();

	public void put(String key, Object value) {
		data.put(key, value);
	}

	public Object get(String key) {
		return data.get(key);
	}

	public Map<String, Object> getAll() {
		return data;
	}

	@Override
	public String toString() {
		return "Context [data=" + data + "]";
	}
}
