package com.adyen.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adyen.modal.SearchCriteria;
import com.adyen.pojo.ApiResponse;
import com.adyen.service.FourSquareService;
import com.adyen.utils.AppUtils;

@Controller
public class LocationController {

	
	@Autowired
	FourSquareService fourSquareService;
	
	@GetMapping(value = "/index")
	public String landingPage() {
		return "index";
	}
	
	@GetMapping(value = "/search")
	public ModelAndView serachPage(@RequestParam String lat, @RequestParam String lon) {
		ApiResponse apiResponse = null;
		SearchCriteria criteria = new SearchCriteria();
		criteria.setLon(lon);
		criteria.setLat(lat);
		
		ModelAndView mv = new ModelAndView("searchpage");
		mv.addObject("criteria", criteria);
		
		apiResponse = fourSquareService.getLocations(criteria);
		if(null == apiResponse) {
			mv.setViewName("errorpage");
			return mv;
		}
		
		mv.addObject("apiresp", apiResponse);		
		return mv;
	}
	
	@PostMapping(value = "/searchcriteria")
	public ModelAndView serachCriteria(@ModelAttribute SearchCriteria criteria) {		
		ApiResponse apiResponse = null;
		ModelAndView mv = new ModelAndView("searchpage");
		mv.addObject("criteria", criteria);
				
		if(AppUtils.isNullOrEmptyString(criteria.getLat()) || AppUtils.isNullOrEmptyString(criteria.getLon())) {
			mv.setViewName("index");
			return mv;
		}
		
		apiResponse = fourSquareService.getLocations(criteria);
		if(null == apiResponse) {
			mv.setViewName("errorpage");
			return mv;
		} if("200".equals(apiResponse.getMeta().getCode()) && null != apiResponse.getResponse().getVenues()
				&& !apiResponse.getResponse().getVenues().isEmpty()) {
			apiResponse = AppUtils.prepareGidResponse(apiResponse);
		}
		mv.addObject("apiresp", apiResponse);		
		return mv;
	}
	
}
