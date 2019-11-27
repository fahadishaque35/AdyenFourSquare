package com.adyen.pojo;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {

	Meta meta;
	Response response;
	List<ThreeVenuesList> threeVenueList = new ArrayList<ThreeVenuesList>();
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public List<ThreeVenuesList> getThreeVenueList() {
		return threeVenueList;
	}
	public void setThreeVenueList(List<ThreeVenuesList> threeVenueList) {
		this.threeVenueList = threeVenueList;
	}
	
}
