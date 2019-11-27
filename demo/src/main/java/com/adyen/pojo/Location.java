package com.adyen.pojo;

import java.util.List;

public class Location {

	public String address;
	public String lat;
	public String lng;
	
	List<LabeledLatLng> labeledLatLngs;
	
	public int distance;
    public String postalCode;
    public String cc;
    public String city;
    public String state;
    public String country;
	
    List<String> formattedAddress;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public List<LabeledLatLng> getLabeledLatLngs() {
		return labeledLatLngs;
	}

	public void setLabeledLatLngs(List<LabeledLatLng> labeledLatLngs) {
		this.labeledLatLngs = labeledLatLngs;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(List<String> formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
       
}
