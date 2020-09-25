package com.spring.hotelspace.common.json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonMapperService {
	public Map<String, String> convertJsonObjectToMap(JSONObject jsonObject) {
		Set<String> jsonKeySet = jsonObject.keySet();
		Iterator<String> iterator = jsonKeySet.iterator();
		Map<String, String> jsonMap = new HashMap<>(); 
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			jsonMap.put(key, jsonObject.get(key) != null ? (String) jsonObject.get(key) : null);
		}
		return jsonMap;
	}
}
