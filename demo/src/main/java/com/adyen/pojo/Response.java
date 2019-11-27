package com.adyen.pojo;

import java.util.List;

public class Response {

	List<Venue> venues;
	boolean confident;
	public List<Venue> getVenues() {
		return venues;
	}
	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}
	public boolean isConfident() {
		return confident;
	}
	public void setConfident(boolean confident) {
		this.confident = confident;
	}
	
}
