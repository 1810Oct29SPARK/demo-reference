package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

import com.revature.beans.Bear;
import com.revature.service.BearService;

@Controller
public class BearController {
	
	@Autowired
	private BearService bearService;
	
	@RequestMapping(value="/bears", method=RequestMethod.GET)
	@ResponseBody //returns just data
	public ResponseEntity<List<Bear>> getAllBears() {
		return null;
	}

	
}
