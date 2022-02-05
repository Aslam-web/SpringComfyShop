package com.controller;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Invoice;
import com.service.CartItemService;
import com.service.PaymentService;
import com.service.UserService;

@Controller
@RequestMapping(value = { "/order", "/payment" })
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Autowired
	CartItemService cartItemService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String showPayment(HttpSession session, ModelMap m) {
		
		// validate user login
		if (!HelperController.validateUserLogin(m, session)) return "failure";
		
		// get and set totalAmount (for adding it as a url params)
		int totalAmount = paymentService.getGrandTotalAmount(session.getAttribute("username").toString());
		m.addAttribute("totalAmount", totalAmount);

		return "payment";
	}

//	@RequestMapping(value = "/pay", method = RequestMethod.POST) // in case the form is filled with payment details
	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public String processPayment(HttpSession session, ModelMap m) {
		// validate user login
		if (!HelperController.validateUserLogin(m, session)) return "failure";

		String username = session.getAttribute("username").toString();

		// m-> user
		m.addAttribute("user", userService.getUser(username));
		// m-> cartItems
		m.addAttribute("cartItems", cartItemService.getUserCartItemsByPaymentStatus(username, "NP"));
		
		Invoice invoice = paymentService.doPayment(username); // NP to P
		m.addAttribute("invoice", invoice);
		m.addAttribute("generatedInvoiceId", String.format("IN_%05d" , invoice.getInvoiceId()));

		return "invoice";
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Pre destroy method in invoice called ................");
	}
}