package com.spring.hotelspace.common.geocode;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;

public interface GeoCodeService {
 
   public String getKakaoApiFromAddress(String roadFullAddr) throws ParseException;
}