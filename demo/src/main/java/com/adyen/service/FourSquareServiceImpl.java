package com.adyen.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.adyen.modal.SearchCriteria;
import com.adyen.pojo.ApiResponse;
import com.adyen.utils.AppUtils;
import com.adyen.utils.Constants;

@Service
public class FourSquareServiceImpl implements FourSquareService{

	
	@Override
	public ApiResponse getLocations(SearchCriteria criteria) {
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpGet request = null;
		 CloseableHttpResponse response  = null;
		 HttpEntity entity = null;
		 StringBuilder urlBuilder = new StringBuilder(Constants.SQUARE_API_URL);
		 StringBuilder catSb = new StringBuilder();
	        try {
	        	
	        	urlBuilder.append("?client_id=").append(Constants.CLIENT_ID).append("&client_secret=").append(Constants.CLIENT_SECRET);
	        	urlBuilder.append("&ll=").append(criteria.getLat()).append(",").append(criteria.getLon());
	        	urlBuilder.append("&v=").append(AppUtils.getCurrentDate());
	        	urlBuilder.append("&radius=").append(AppUtils.isNullOrEmptyString(criteria.getRadius()) ? "5000" : criteria.getRadius());
	        		        		        	
	        	if(!AppUtils.isNullOrEmptyString(criteria.getDiner())) {
	        		catSb.append("4bf58dd8d48988d147941735");
	        	} if(!AppUtils.isNullOrEmptyString(criteria.getHospital())) {
	        		if(!AppUtils.isNullOrEmptyString(catSb.toString()))
	        			catSb.append(",");
	        		catSb.append("4bf58dd8d48988d196941735");
	        	} if(!AppUtils.isNullOrEmptyString(criteria.getPark())) {
	        		if(!AppUtils.isNullOrEmptyString(catSb.toString()))
	        			catSb.append(",");
	        		catSb.append("4bf58dd8d48988d182941735");
	        	}
	        	
	        	urlBuilder.append("&categoryId=").append(catSb.toString());
	        	System.out.println("Url : " + urlBuilder.toString());
	            request = new HttpGet(urlBuilder.toString());
	            response = httpClient.execute(request);

	            try {

	                // Get HttpResponse Status
	                System.out.println(response.getStatusLine().getStatusCode());   // 200

	                entity = response.getEntity();
	                if (entity != null) {
	                    // return it as a String
	                    String result = EntityUtils.toString(entity);
	                    return AppUtils.parseResult(result);
	                }

	            } finally {
	                response.close();
	            }
	        } catch(Exception e){
	        	e.printStackTrace();
	        } finally {
	            try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		return null;
	}
}
