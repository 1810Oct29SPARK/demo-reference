package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.beans.User;
import com.revature.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	private LoginService loginService;

	// deliver static resources from an endpoint "/login"
	@GetMapping(value = "/login")
	public String getStaticLoginPage() {
		return "forward:/static/staticLogin.html";
	}

	// handle form data sent to "/login"
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public RedirectView handleFormRequest(@RequestBody MultiValueMap<String, String> formParams, RedirectAttributes attributes) {
		//System.out.println("form params received: " + formParams);
		// process form data
		User u = loginService.validateUser(formParams.getFirst("username"), formParams.getFirst("password"));
		if (u == null) {
			// redirect to error page
			return new RedirectView("error");
		} else {
			// redirect to profile
			attributes.addFlashAttribute("user",u);
			return new RedirectView("profile");
		}
	}
	
	@GetMapping(value="/error")
	public String getErrorPage() {
		return "error";
	}

}
