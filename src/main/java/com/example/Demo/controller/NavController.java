package com.example.Demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NavController {
	@GetMapping("/map-register")
	public String registerMapping() {
		return "signUp";
	}
	
	@GetMapping("/map-login")
	public String loginMapping() {
		return "login";
	}
	
	@GetMapping("/map-songs")
	public String songMapping() {
		return "addsongs";
	}
	
	
	@GetMapping("/SamplePayment")
	public String SamplePayment() {
		return "SamplePayment";
	}
	

}
