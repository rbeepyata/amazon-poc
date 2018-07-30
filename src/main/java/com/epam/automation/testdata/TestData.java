package com.epam.automation.testdata;

import java.util.Map;

public final class TestData {

	private Map<String, String> data;

	public String get(String key) {
		return data.get(key);
	}

	public void setData(Map<String, String> map) {
		data = map;
	}

}
