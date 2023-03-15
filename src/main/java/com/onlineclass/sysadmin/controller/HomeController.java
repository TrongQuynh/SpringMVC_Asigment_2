package com.onlineclass.sysadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String homePage(Model model) {

		return "HomeView";
	}
	
	@RequestMapping(value = "/login")
	public String loginPage(Model model) {

		return "LoginView";
	}
}
