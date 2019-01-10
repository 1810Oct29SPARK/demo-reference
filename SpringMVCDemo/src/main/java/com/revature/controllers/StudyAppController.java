package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudyAppController {

	// to return bundled Angular app
	// bundle with: ng build --prod --base-href=SpringMVCDemo/ --deploy-url=SpringMVCDemo/static/

	@GetMapping(value = "/study-app")
	public String getApp() {
		return "forward:/static/index.html";
	}

}
