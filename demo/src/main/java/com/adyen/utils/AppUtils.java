package com.adyen.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.adyen.pojo.ApiResponse;
import com.adyen.pojo.ThreeVenuesList;
import com.adyen.pojo.Venue;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class AppUtils {
	
	public static String getCurrentDate() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("YYYYMMDD");
		return format.format(date);
	}
	
	public static boolean isNullOrEmptyString(String str) {
		if(null == str || "".equals(str))
			return true;
		return false;
	}
	
	public static ApiResponse parseResult(String result) {
		Gson g = new Gson();
		ApiResponse apiResponse = g.fromJson(result, ApiResponse.class);
		return apiResponse;
	}
	
	public static ApiResponse prepareGidResponse(ApiResponse response) {
		int counter = 0;
		ThreeVenuesList threeList = null;
		for(Venue v : response.getResponse().getVenues()) {
			
			if(counter == 3) {
				counter = 0;
			}
			
			if(v.getName().contains("HAQ WALI SARKAR")) {
				v.setName(v.getName());
			}
			
			if(counter == 0) {
				threeList = new ThreeVenuesList();
				response.getThreeVenueList().add(threeList);
				threeList.getVenues().add(v);
				counter++;
			} else {
				counter++;
				response.getThreeVenueList().get(0).getVenues().add(v);
			}
		}
		
		return response;
	}

}
