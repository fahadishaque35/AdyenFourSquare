package com.adyen.service;

import com.adyen.modal.SearchCriteria;
import com.adyen.pojo.ApiResponse;

public interface FourSquareService {
	
	public ApiResponse getLocations(SearchCriteria criteria);

}
