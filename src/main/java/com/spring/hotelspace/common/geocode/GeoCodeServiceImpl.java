package com.spring.hotelspace.common.geocode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hotelspace.client.login.vo.ClientLoginVO;
import com.spring.hotelspace.client.mypage.dao.ClientMyPageDAO;
import com.spring.hotelspace.client.mypage.service.ClientMyPageService;
import com.spring.hotelspace.client.mypage.vo.ClientMyPageVO;
import com.spring.hotelspace.client.search.vo.ClientHotelVO;

@Service
public class GeoCodeServiceImpl implements GeoCodeService {

   @Override
   public String getKakaoApiFromAddress(String roadFullAddr) throws ParseException {
      String apiKey = "c62bdf08831d1a155ad5f32d9a2cd4f1";
      String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
      String jsonString = null;
      
      try {
          roadFullAddr = URLEncoder.encode( roadFullAddr, "UTF-8");

         String addr = apiUrl + "?query=" +  roadFullAddr;

         URL url = new URL(addr);
         URLConnection conn = url.openConnection();
         conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);

         BufferedReader rd = null;
         rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
         StringBuffer docJson = new StringBuffer();

         String line;

         while ((line = rd.readLine()) != null) {
            docJson.append(line);
         }

         jsonString = docJson.toString();
         rd.close();

      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      

      System.out.println("java :"+jsonString);
      
      return jsonString;

   }

}