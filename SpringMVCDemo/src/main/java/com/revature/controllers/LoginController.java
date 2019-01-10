package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	//deliver static resources from an endpoint "/login"
	@GetMapping(value="/login")
	public String getStaticLoginPage() {
		return "forward:/static/staticLogin.html";
	}

}
