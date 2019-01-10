package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.User;

@Controller
public class ProfileController {
	
	@GetMapping(value="/profile")
	public ModelAndView getProfilePage(@ModelAttribute("user") User user, ModelMap m) {
		m.addAttribute("username", user.getUsername());
		m.addAttribute("email", user.getEmail());
		return new ModelAndView("profile", m);
	}

}
