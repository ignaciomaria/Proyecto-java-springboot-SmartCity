package com.grupo15.SmartCity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grupo15.SmartCity.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("")
	public ModelAndView menu() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MENU);
		return mAV;
	}
}
