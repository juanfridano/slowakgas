package com.slogas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@RequestMapping("/updateDB")
	public String showUpdateSite() {
		
		return "updateDB";
	}
	
	@RequestMapping("/retrieve")
	public String showRetrieveSite() {
		
		return "retrieve";
	}
	
}
