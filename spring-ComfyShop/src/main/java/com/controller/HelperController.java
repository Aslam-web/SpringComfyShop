package com.controller;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelperController {

	public static boolean validateUserLogin(ModelMap m, HttpSession session) {
		if (session.getAttribute("username") == null || session.getAttribute("username").equals("")) {
			m.addAttribute("error_info", "Make sure you are logged in before proceeding");
			return false;
		}
		return true;
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Pre destroy method in helper controller called ................");
	}
}