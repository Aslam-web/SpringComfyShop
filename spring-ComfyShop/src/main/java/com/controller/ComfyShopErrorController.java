package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComfyShopErrorController implements ErrorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComfyShopErrorController.class);
	
//	@RequestMapping("/error")
	public String handleError(HttpServletRequest req, Exception ex, ModelMap m) {
		System.out.println("Request: " + req.getRequestURL() + " raised " + ex);
		LOGGER.error("Request: " + req.getRequestURL() + " raised " + ex);

		m.addAttribute("exception", ex);
		m.addAttribute("url", req.getRequestURL());
		return "error";
	}
}
